package com.senasa.tupaserver.ubigeo.domain;

import java.util.List;
import com.senasa.tupaserver.ubigeo.domain.dtos.DepartamentoFindDto;
import com.senasa.tupaserver.ubigeo.domain.dtos.DepartamentoListDto;
import com.senasa.tupaserver.ubigeo.domain.dtos.DistritoFindDto;
import com.senasa.tupaserver.ubigeo.domain.dtos.DistritoListDto;
import com.senasa.tupaserver.ubigeo.domain.dtos.PobladoFindDto;
import com.senasa.tupaserver.ubigeo.domain.dtos.PobladoListDto;
import com.senasa.tupaserver.ubigeo.domain.dtos.ProvinciaFindDto;
import com.senasa.tupaserver.ubigeo.domain.dtos.ProvinciaListDto;
import com.senasa.tupaserver.ubigeo.domain.dtos.UbigeoFindDto;
import com.senasa.tupaserver.ubigeo.domain.dtos.UbigeoListDto;

public interface UbigeoRepository {
  List<PaisEntity> listPaises();

  List<UbigeoEntity> listUbigeos(UbigeoListDto params);

  UbigeoEntity findUbigeo(UbigeoFindDto params);

  List<PobladoEntity> listPoblados(PobladoListDto params);

  PobladoEntity findPoblado(PobladoFindDto params);

  List<DepartamentoEntity> listDepartamentos(DepartamentoListDto params);

  DepartamentoEntity findDepartamento(DepartamentoFindDto params);

  List<ProvinciaEntity> listProvincias(ProvinciaListDto params);

  ProvinciaEntity findProvincia(ProvinciaFindDto params);

  List<DistritoEntity> listDistritos(DistritoListDto params);

  DistritoEntity findDistrito(DistritoFindDto params);
}
