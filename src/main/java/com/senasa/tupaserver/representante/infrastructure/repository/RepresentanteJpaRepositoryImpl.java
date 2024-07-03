package com.senasa.tupaserver.representante.infrastructure.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.senasa.tupaserver.representante.domain.RepresentanteMapper;
import com.senasa.tupaserver.representante.domain.RepresentanteRepository;
import com.senasa.tupaserver.representante.domain.dtos.RepresentanteCreateDto;
import com.senasa.tupaserver.representante.domain.dtos.RepresentanteFindDto;
import com.senasa.tupaserver.representante.domain.dtos.RepresentanteListDto;
import com.senasa.tupaserver.representante.domain.dtos.RepresentantePaginateDto;
import com.senasa.tupaserver.representante.infrastructure.repository.jdbc.RepresentanteSelectJdbc;
import com.senasa.tupaserver.shared.sql.PaginateMeta;
import com.senasa.tupaserver.shared.sql.PaginateResponse;
import com.senasa.tupaserver.shared.sql.PaginateSql;
import com.senasa.tupaserver.shared.sql.QueryBuilderSql;

@Service
public class RepresentanteJpaRepositoryImpl implements RepresentanteRepository {
  @Autowired
  RepresentanteJpaRepository repository;

  @Autowired
  JdbcTemplate jdbcTemplate;

  @Autowired
  ModelMapper modelMapper;

  @Override
  public RepresentanteMapper findRepresentante(RepresentanteFindDto request) {
    QueryBuilderSql queryBuilder = new RepresentanteSelectJdbc()
        .query(this.modelMapper.map(request, RepresentanteListDto.class));
    return this.jdbcTemplate.query(queryBuilder.getSql(),
        (row, index) -> new RepresentanteMapper(row, index))
        .stream()
        .findFirst()
        .get();
  }

  @Override
  public List<RepresentanteMapper> listRepresentantes(RepresentanteListDto request) {
    QueryBuilderSql queryBuilder = new RepresentanteSelectJdbc().query(request);
    return this.jdbcTemplate.query(queryBuilder.getSql(),
        (row, index) -> new RepresentanteMapper(row, index));
  }

  @Override
  public PaginateResponse<RepresentanteMapper> paginateRepresentantes(RepresentantePaginateDto request)
      throws Exception {
    PageRequest page = PageRequest.of(request.getPage(), request.getLimit());
    QueryBuilderSql queryBuilder = new RepresentanteSelectJdbc().query(request);
    PaginateSql<RepresentanteMapper> paginate = new PaginateSql<RepresentanteMapper>(this.jdbcTemplate, queryBuilder);
    paginate.execute(page);
    List<RepresentanteMapper> items = this.jdbcTemplate.query(paginate.getSqlData(),
        (row, index) -> new RepresentanteMapper(row, index));
    PaginateMeta meta = new PaginateMeta((PageRequest) page, items.size(), paginate.getTotal());
    return new PaginateResponse<RepresentanteMapper>(meta, items);
  }

  @SuppressWarnings("null")
  @Override
  public void createRepresentante(RepresentanteCreateDto request) throws SQLException {
    String sql = "CALL PCKG_PERSONA.Sp_Registrar_Representante(?, ?, ?, ?, ?, ?, ?, ?)";
    Connection connection = this.jdbcTemplate.getDataSource().getConnection();
    CallableStatement cs = connection.prepareCall(sql);
    cs.setString(1, request.getPersonId());
    cs.setString(2, request.getRepresentanteId());
    cs.setString(3, request.getFullname());
    cs.setString(4, request.getCargo());
    cs.setString(5, request.getCargoDate());
    cs.setString(6, request.getOrder());
    cs.setString(7, request.getState());
    cs.setString(8, request.getUser());
    cs.execute();
  }
}
