package com.senasa.tupaserver.expediente.application;

import java.sql.Connection;
import javax.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.senasa.tupaserver.cuarentena.domain.CuarentenaRepository;
import com.senasa.tupaserver.cuarentena.domain.dtos.CuarentenaCreateDto;
import com.senasa.tupaserver.cuarentena.domain.dtos.CuarentenaListDto;
import com.senasa.tupaserver.detalle.domain.DetalleRepository;
import com.senasa.tupaserver.detalle.domain.dtos.DetalleCreateDto;
import com.senasa.tupaserver.expediente.domain.ExpedienteMapper;
import com.senasa.tupaserver.expediente.domain.ExpedienteRepository;
import com.senasa.tupaserver.expediente.domain.dtos.ExpedienteSaveProductDto;
import com.senasa.tupaserver.expediente.domain.dtos.ExpedienteSaveDto;
import com.senasa.tupaserver.expediente.domain.dtos.ExpedienteSaveResponseDto;
import com.senasa.tupaserver.shared.http.domain.ErrorNotFoundException;
import com.senasa.tupaserver.expediente.domain.dtos.ExpedienteFindDto;

public class ExpedienteEditService {
  public ExpedienteEditService(
      ExpedienteRepository expedienteRepository,
      DetalleRepository detalleRepository,
      CuarentenaRepository cuarentenaRepository,
      ModelMapper modelMapper) {
    this.expedienteRepository = expedienteRepository;
    this.detalleRepository = detalleRepository;
    this.cuarentenaRepository = cuarentenaRepository;
    this.modelMapper = modelMapper;
  }

  ExpedienteRepository expedienteRepository;
  DetalleRepository detalleRepository;
  CuarentenaRepository cuarentenaRepository;
  ModelMapper modelMapper;

  @Transactional(propagation = Propagation.REQUIRED)
  public ExpedienteSaveResponseDto execute(
      @Valid ExpedienteFindDto params, @Valid ExpedienteSaveDto payload)
      throws Exception {
    // obtener el expediente
    ExpedienteMapper expediente = this.expedienteRepository.findExpediente(params);
    // validar expediente
    if (expediente == null) {
      throw new ErrorNotFoundException("No se encontró el expediente");
    }
    // generar proceso
    this.expedienteRepository.createConnection();
    Connection connection = this.expedienteRepository.getConnection();
    this.detalleRepository.setConnection(connection);
    this.cuarentenaRepository.setConnection(connection);
    connection.setAutoCommit(false);
    // process save expediente
    try {
      // crear detalle
      payload.setId(expediente.getId());
      ExpedienteSaveResponseDto response = this.expedienteRepository.saveExpediente(payload);
      DetalleCreateDto detallePayload = this.modelMapper.map(payload.getDetalle(), DetalleCreateDto.class);
      detallePayload.setExpedienteId(response.getId());
      detallePayload.setEstablishmentId(payload.getEstablishmentId());
      detallePayload.setTechnicalId(payload.getTechnicalId());
      this.detalleRepository.createDetalle(detallePayload);
      // eliminar products
      CuarentenaListDto productDeleteParams = new CuarentenaListDto();
      productDeleteParams.setExpedienteId(expediente.getId());
      this.cuarentenaRepository.deleteCuarentenas(productDeleteParams);
      // crear products
      for (ExpedienteSaveProductDto item : payload.getProducts()) {
        CuarentenaCreateDto cuarentenaPayload = this.modelMapper.map(item, CuarentenaCreateDto.class);
        cuarentenaPayload.setExpedienteId(response.getId());
        this.cuarentenaRepository.createCuarentena(cuarentenaPayload);
      }
      // commit
      connection.commit();
      return response;
    } catch (Throwable err) {
      connection.rollback();
      throw err;
    } finally {
      connection.setAutoCommit(true);
      connection.close();
    }
  }
}
