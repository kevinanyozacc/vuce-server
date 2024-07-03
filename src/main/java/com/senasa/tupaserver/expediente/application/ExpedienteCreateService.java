package com.senasa.tupaserver.expediente.application;

import java.sql.Connection;
import javax.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.senasa.tupaserver.cuarentena.domain.CuarentenaRepository;
import com.senasa.tupaserver.cuarentena.domain.dtos.CuarentenaCreateDto;
import com.senasa.tupaserver.detalle.domain.DetalleRepository;
import com.senasa.tupaserver.detalle.domain.dtos.DetalleCreateDto;
import com.senasa.tupaserver.expediente.domain.ExpedienteRepository;
import com.senasa.tupaserver.expediente.domain.dtos.ExpedienteSaveDto;
import com.senasa.tupaserver.expediente.domain.dtos.ExpedienteSaveProductDto;
import com.senasa.tupaserver.expediente.domain.dtos.ExpedienteSaveResponseDto;

public class ExpedienteCreateService {
  public ExpedienteCreateService(
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
  public ExpedienteSaveResponseDto execute(@Valid ExpedienteSaveDto params) throws Exception {
    this.expedienteRepository.createConnection();
    Connection connection = this.expedienteRepository.getConnection();
    this.detalleRepository.setConnection(connection);
    this.cuarentenaRepository.setConnection(connection);
    connection.setAutoCommit(false);
    // process save expediente
    try {
      // crear detalle
      ExpedienteSaveResponseDto response = this.expedienteRepository.saveExpediente(params);
      DetalleCreateDto detallePayload = this.modelMapper.map(params.getDetalle(), DetalleCreateDto.class);
      detallePayload.setExpedienteId(response.getId());
      detallePayload.setEstablishmentId(params.getEstablishmentId());
      detallePayload.setTechnicalId(params.getTechnicalId());
      this.detalleRepository.createDetalle(detallePayload);
      // crear cuarentenas
      for (ExpedienteSaveProductDto item : params.getProducts()) {
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
