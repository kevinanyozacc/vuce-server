package com.senasa.tupaserver.ubigeo.infrastructure.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.senasa.tupaserver.ubigeo.application.UbigeoDepartamentoListService;
import com.senasa.tupaserver.ubigeo.application.UbigeoDistritoListService;
import com.senasa.tupaserver.ubigeo.application.UbigeoPaisListService;
import com.senasa.tupaserver.ubigeo.application.UbigeoPobladoListService;
import com.senasa.tupaserver.ubigeo.application.UbigeoProvinaciaListService;
import com.senasa.tupaserver.ubigeo.domain.DepartamentoEntity;
import com.senasa.tupaserver.ubigeo.domain.DistritoEntity;
import com.senasa.tupaserver.ubigeo.domain.PaisEntity;
import com.senasa.tupaserver.ubigeo.domain.PobladoEntity;
import com.senasa.tupaserver.ubigeo.domain.ProvinciaEntity;
import com.senasa.tupaserver.ubigeo.domain.dtos.DepartamentoListDto;
import com.senasa.tupaserver.ubigeo.domain.dtos.DistritoListDto;
import com.senasa.tupaserver.ubigeo.domain.dtos.PobladoListDto;
import com.senasa.tupaserver.ubigeo.domain.dtos.ProvinciaListDto;
import com.senasa.tupaserver.ubigeo.infrastructure.repository.UbigeoJpaRepositoryImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/ubigeos")
public class UbigeoHttpController {
  @Autowired
  UbigeoJpaRepositoryImpl ubigeoRepository;

  @GetMapping(path = { "/", "" })
  public List<DepartamentoEntity> getDepartamentos() {
    DepartamentoListDto request = new DepartamentoListDto();
    UbigeoDepartamentoListService service = new UbigeoDepartamentoListService(ubigeoRepository);
    return service.execute(request);
  }

  @GetMapping("/paises")
  public List<PaisEntity> getPaises() {
    UbigeoPaisListService service = new UbigeoPaisListService(ubigeoRepository);
    return service.execute();
  }

  @GetMapping("/{id}/provincias")
  public List<ProvinciaEntity> getProvincias(@PathVariable String id) {
    ProvinciaListDto request = new ProvinciaListDto();
    request.setDepartamentoId(id);
    UbigeoProvinaciaListService service = new UbigeoProvinaciaListService(ubigeoRepository);
    return service.execute(request);
  }

  @GetMapping("/{id}/provincias/{provinciaId}/distritos")
  public List<DistritoEntity> getDistritos(
      @PathVariable String id,
      @PathVariable String provinciaId) {
    DistritoListDto request = new DistritoListDto();
    request.setDepartamentoId(id);
    request.setProvinciaId(provinciaId);
    UbigeoDistritoListService service = new UbigeoDistritoListService(ubigeoRepository);
    return service.execute(request);
  }

  @GetMapping("/{id}/provincias/{provinciaId}/distritos/{distritoId}/poblados")
  public List<PobladoEntity> getPoblados(
      @PathVariable String id,
      @PathVariable String provinciaId,
      @PathVariable String distritoId) {
    PobladoListDto request = new PobladoListDto();
    request.setDepartamentoId(id);
    request.setProvinciaId(provinciaId);
    request.setDistritoId(distritoId);
    UbigeoPobladoListService service = new UbigeoPobladoListService(ubigeoRepository);
    return service.execute(request);
  }
}
