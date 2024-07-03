package com.senasa.tupaserver.ubigeo.infrastructure.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.senasa.tupaserver.shared.sql.QueryBuilderSql;
import com.senasa.tupaserver.ubigeo.domain.DepartamentoEntity;
import com.senasa.tupaserver.ubigeo.domain.DepartamentoMapper;
import com.senasa.tupaserver.ubigeo.domain.DistritoEntity;
import com.senasa.tupaserver.ubigeo.domain.DistritoMapper;
import com.senasa.tupaserver.ubigeo.domain.PaisEntity;
import com.senasa.tupaserver.ubigeo.domain.PaisMapper;
import com.senasa.tupaserver.ubigeo.domain.PobladoEntity;
import com.senasa.tupaserver.ubigeo.domain.PobladoMapper;
import com.senasa.tupaserver.ubigeo.domain.ProvinciaEntity;
import com.senasa.tupaserver.ubigeo.domain.ProvinciaMapper;
import com.senasa.tupaserver.ubigeo.domain.UbigeoEntity;
import com.senasa.tupaserver.ubigeo.domain.UbigeoMapper;
import com.senasa.tupaserver.ubigeo.domain.UbigeoRepository;
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

@Service
public class UbigeoJpaRepositoryImpl implements UbigeoRepository {
  @Autowired
  JdbcTemplate jdbcTemplate;

  @Autowired
  ModelMapper modelMapper;

  @Override
  public List<PaisEntity> listPaises() {
    List<PaisEntity> data = new ArrayList<PaisEntity>();
    QueryBuilderSql query = new QueryBuilderSql().from("SIGA.TPAISES")
        .andWhere("ESTADO = 'ACTIVO'")
        .orderBy("NOMB_PAIS_TPA", "ASC");
    this.jdbcTemplate.query(query.getSql(), (item, index) -> new PaisMapper(item, index))
        .forEach(item -> data.add((PaisEntity) item));
    return data;
  }

  @Override
  public List<DepartamentoEntity> listDepartamentos(DepartamentoListDto params) {
    List<DepartamentoEntity> data = new ArrayList<DepartamentoEntity>();
    QueryBuilderSql query = new QueryBuilderSql().from("SIGA.Tdepartamentos");
    this.jdbcTemplate.query(query.getSql(), (item, index) -> new DepartamentoMapper(item, index))
        .forEach(item -> data.add((DepartamentoEntity) item));
    return data;
  }

  @Override
  public DepartamentoEntity findDepartamento(DepartamentoFindDto params) {
    QueryBuilderSql query = new QueryBuilderSql().from("SIGA.Tdepartamentos");
    // filters
    if (params.getName() != null) {
      query.andWhere("UPPER(NOMB_DPTO_DPT) = UPPER('" + params.getName() + "')");
    }
    // query
    Optional<DepartamentoMapper> mapper = this.jdbcTemplate
        .query(query.getSql(),
            (item, index) -> new DepartamentoMapper(item, index))
        .stream().findFirst();
    // response
    return this.modelMapper.map(mapper, DepartamentoEntity.class);
  }

  @Override
  public List<ProvinciaEntity> listProvincias(ProvinciaListDto params) {
    List<ProvinciaEntity> data = new ArrayList<ProvinciaEntity>();
    QueryBuilderSql query = new QueryBuilderSql().from("Siga.Tprovincias");
    // filters
    if (params.getDepartamentoId() != null) {
      String condition = params.getDepartamentoId();
      query.andWhere("CODI_DEPA_DPT = '" + condition + "'");
    }
    // get data
    this.jdbcTemplate.query(query.getSql(), (item, index) -> new ProvinciaMapper(item, index))
        .forEach(item -> data.add((ProvinciaEntity) item));
    return data;
  }

  @Override
  public ProvinciaEntity findProvincia(ProvinciaFindDto params) {
    QueryBuilderSql query = new QueryBuilderSql().from("SIGA.Tprovincias");
    // filters
    if (params.getName() != null) {
      query.andWhere("UPPER(NOMB_PROV_TPR) = UPPER('" + params.getName() + "')");
    }
    // query
    Optional<ProvinciaMapper> mapper = this.jdbcTemplate
        .query(query.getSql(),
            (item, index) -> new ProvinciaMapper(item, index))
        .stream().findFirst();
    // response
    return this.modelMapper.map(mapper, ProvinciaEntity.class);
  }

  @Override
  public List<DistritoEntity> listDistritos(DistritoListDto params) {
    List<DistritoEntity> data = new ArrayList<DistritoEntity>();
    QueryBuilderSql query = new QueryBuilderSql().from("Siga.Tdistritos");
    // filters
    if (params.getDepartamentoId() != null) {
      String condition = params.getDepartamentoId();
      query.andWhere("CODI_DEPA_DPT = '" + condition + "'");
    }
    if (params.getProvinciaId() != null) {
      String condition = params.getProvinciaId();
      query.andWhere("CODI_PROV_TPR = '" + condition + "'");
    }
    // get data
    this.jdbcTemplate.query(query.getSql(), (item, index) -> new DistritoMapper(item, index))
        .forEach(item -> data.add((DistritoEntity) item));
    return data;
  }

  @Override
  public DistritoEntity findDistrito(DistritoFindDto params) {
    QueryBuilderSql query = new QueryBuilderSql().from("SIGA.Tdistritos");
    // filters
    if (params.getName() != null) {
      query.andWhere("UPPER(NOMB_DIST_TDI) = UPPER('" + params.getName() + "')");
    }
    // query
    Optional<DistritoMapper> mapper = this.jdbcTemplate
        .query(query.getSql(),
            (item, index) -> new DistritoMapper(item, index))
        .stream().findFirst();
    // response
    return this.modelMapper.map(mapper, DistritoEntity.class);
  }

  @Override
  public List<UbigeoEntity> listUbigeos(UbigeoListDto params) {
    List<UbigeoEntity> data = new ArrayList<UbigeoEntity>();
    QueryBuilderSql query = this.queryUbigeo(params);
    // get data
    this.jdbcTemplate.query(query.getSql(), (item, index) -> new UbigeoMapper(item, index))
        .forEach(item -> data.add((UbigeoEntity) item));
    return data;
  }

  @Override
  public UbigeoEntity findUbigeo(UbigeoFindDto params) {
    UbigeoEntity data = new UbigeoEntity();
    QueryBuilderSql query = this.queryUbigeo((UbigeoListDto) params);
    // get data
    List<UbigeoMapper> ubigeos = this.jdbcTemplate.query(query.getSql(),
        (item, index) -> new UbigeoMapper(item, index));
    for (UbigeoMapper ubigeoMapper : ubigeos) {
      return this.modelMapper.map(ubigeoMapper, UbigeoEntity.class);
    }
    // response
    return data;
  }

  @Override
  public List<PobladoEntity> listPoblados(PobladoListDto params) {
    List<PobladoEntity> data = new ArrayList<PobladoEntity>();
    QueryBuilderSql query = this.queryPoblado(params);
    // get data
    this.jdbcTemplate.query(query.getSql(), (item, index) -> new PobladoMapper(item, index))
        .forEach(item -> data.add((PobladoEntity) item));
    return data;
  }

  @Override
  public PobladoEntity findPoblado(PobladoFindDto params) {
    PobladoEntity data = new PobladoEntity();
    QueryBuilderSql query = this.queryPoblado((PobladoListDto) params);
    // get data
    List<PobladoMapper> centros = this.jdbcTemplate.query(query.getSql(),
        (item, index) -> new PobladoMapper(item, index));
    for (PobladoMapper pobladoMapper : centros) {
      return this.modelMapper.map(pobladoMapper, PobladoEntity.class);
    }
    // response
    return data;
  }

  private QueryBuilderSql queryUbigeo(UbigeoListDto params) {
    QueryBuilderSql query = new QueryBuilderSql().from("Siga.Tdepartamentos dep")
        .innerJoin("Siga.Tprovincias pro", "pro.CODI_DEPA_DPT = dep.CODI_DEPA_DPT")
        .innerJoin("Siga.Tdistritos dis",
            "dis.CODI_PROV_TPR = pro.CODI_PROV_TPR AND dis.CODI_DEPA_DPT = dep.CODI_DEPA_DPT");
    // filters
    if (params.getId() != null) {
      String condition = params.getId();
      query.andWhere("dep.CODI_DEPA_DPT || pro.CODI_PROV_TPR  || dis.CODI_DIST_TDI = '" + condition + "'");
    }
    if (params.getDepartamentoId() != null) {
      String condition = params.getDepartamentoId();
      query.andWhere("dep.CODI_DEPA_DPT = '" + condition + "'");
    }
    if (params.getProvinciaId() != null) {
      String condition = params.getProvinciaId();
      query.andWhere("pro.CODI_PROV_TPR = '" + condition + "'");
    }
    if (params.getDistritoId() != null) {
      String condition = params.getProvinciaId();
      query.andWhere("dis.CODI_DIST_TDI = '" + condition + "'");
    }
    // filters arrays
    if (params.getArrayId().size() > 0) {
      String condition = "'" + String.join("', '", params.getArrayId()) + "'";
      query.andWhere("dep.CODI_DEPA_DPT || pro.CODI_PROV_TPR  || dis.CODI_DIST_TDI IN (" + condition + ")");
    }
    // response
    return query;
  }

  private QueryBuilderSql queryPoblado(PobladoListDto params) {
    QueryBuilderSql query = new QueryBuilderSql().from("Siga.CENTROS_POBLADOS");
    // filters
    if (params.getId() != null) {
      String condition = params.getId();
      query.andWhere("CODI_DEPA_DPT || CODI_PROV_TPR || CODI_DIST_TDI || CODI_CCPP_TCP = '" + condition + "'");
    }
    if (params.getDepartamentoId() != null) {
      String condition = params.getDepartamentoId();
      query.andWhere("CODI_DEPA_DPT = '" + condition + "'");
    }
    if (params.getProvinciaId() != null) {
      String condition = params.getProvinciaId();
      query.andWhere("CODI_PROV_TPR = '" + condition + "'");
    }
    if (params.getDistritoId() != null) {
      String condition = params.getDistritoId();
      query.andWhere("CODI_DIST_TDI = '" + condition + "'");
    }
    if (params.getCentroId() != null) {
      String condition = params.getCentroId();
      query.andWhere("CODI_CCPP_TCP = '" + condition + "'");
    }
    // array filters
    if (params.getArrayId().size() > 0) {
      String condition = "'" + String.join("', '", params.getArrayId()) + "'";
      query.andWhere("CODI_DEPA_DPT || CODI_PROV_TPR || CODI_DIST_TDI || CODI_CCPP_TCP IN (" + condition + ")");
    }
    // response
    return query;
  }

}
