package com.senasa.tupaserver.expediente.infrastructure.controllers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import javax.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.senasa.tupaserver.cuarentena.infrastructure.repository.CuarentenaJdbcRepository;
import com.senasa.tupaserver.detalle.infrastructure.repository.DetalleJdbcRepository;
import com.senasa.tupaserver.establishment.infrastructure.repository.EstablishmentJpaRepositoryImpl;
import com.senasa.tupaserver.expediente.application.ExpedienteCreateService;
import com.senasa.tupaserver.expediente.application.ExpedienteEditService;
import com.senasa.tupaserver.expediente.application.ExpedienteFindService;
import com.senasa.tupaserver.expediente.application.ExpedienteInfoService;
import com.senasa.tupaserver.expediente.domain.ExpedienteMapper;
import com.senasa.tupaserver.expediente.domain.dtos.ExpedienteSaveDto;
import com.senasa.tupaserver.expediente.domain.dtos.ExpedienteSaveResponseDto;
import com.senasa.tupaserver.expediente.domain.dtos.ExpedienteFindDto;
import com.senasa.tupaserver.expediente.domain.dtos.ExpedienteInfoResponseDto;
import com.senasa.tupaserver.expediente.infrastructure.reports.ExpedienteReciboReport;
import com.senasa.tupaserver.expediente.infrastructure.repository.ExpedienteJdbcRepository;
import com.senasa.tupaserver.person.infrastructure.repository.PersonJpaRepositoryImpl;
import com.senasa.tupaserver.representante.infrastructure.repository.RepresentanteJpaRepositoryImpl;
import com.senasa.tupaserver.shared.http.domain.ErrorNotFoundException;
import net.sf.jasperreports.engine.JRException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/expedientes")
public class ExpedienteHttpController {
  @Autowired
  JdbcTemplate jdbcTemplate;

  @Autowired
  ExpedienteJdbcRepository expedienteRepository;

  @Autowired
  PersonJpaRepositoryImpl personRepository;

  @Autowired
  RepresentanteJpaRepositoryImpl representanteRepository;

  @Autowired
  EstablishmentJpaRepositoryImpl establishmentRepository;

  @Autowired
  DetalleJdbcRepository detalleRepository;

  @Autowired
  CuarentenaJdbcRepository cuarentenaRepository;

  @Autowired
  ModelMapper modelMapper;

  @GetMapping("/{id}")
  public ExpedienteMapper findExpediente(@PathVariable("id") String id) throws SQLException, ErrorNotFoundException {
    ExpedienteFindDto request = new ExpedienteFindDto();
    request.setId(id);
    ExpedienteFindService service = new ExpedienteFindService(expedienteRepository);
    return service.execute(request);
  }

  @PostMapping("generic")
  public ExpedienteSaveResponseDto createExpediente(@RequestBody @Valid ExpedienteSaveDto params)
      throws Exception {
    ExpedienteCreateService service = new ExpedienteCreateService(
        this.expedienteRepository,
        this.detalleRepository,
        this.cuarentenaRepository,
        this.modelMapper);
    return service.execute(params);
  }

  @PutMapping("/{id}")
  public ExpedienteSaveResponseDto putMethodName(@PathVariable("id") String id,
      @RequestBody @Valid ExpedienteSaveDto payload) throws Exception {
    ExpedienteFindDto params = new ExpedienteFindDto();
    params.setId(id);
    ExpedienteEditService service = new ExpedienteEditService(
        expedienteRepository,
        detalleRepository,
        cuarentenaRepository,
        modelMapper);
    return service.execute(params, payload);
  }

  @GetMapping("/{id}/info")
  public ExpedienteInfoResponseDto info(@PathVariable("id") String id) throws SQLException, ErrorNotFoundException {
    ExpedienteFindDto request = new ExpedienteFindDto();
    request.setId(id);
    ExpedienteInfoService service = new ExpedienteInfoService(
        expedienteRepository,
        this.personRepository,
        this.representanteRepository,
        this.establishmentRepository,
        this.detalleRepository,
        this.cuarentenaRepository,
        this.modelMapper);
    return service.execute(request);
  }

  @GetMapping("/{id}/boleta.pdf")
  public ResponseEntity<byte[]> boletePdf(@PathVariable String id)
      throws FileNotFoundException, IOException, JRException, SQLException {
    byte[] report = new ExpedienteReciboReport(this.jdbcTemplate).render(id);
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_PDF);
    headers.setContentDispositionFormData("filename", "boleta.pdf");
    headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
    return new ResponseEntity<>(report, headers, HttpStatus.OK);
  }

}
