package com.senasa.tupaserver.representante.domain;

import java.sql.SQLException;
import java.util.List;
import com.senasa.tupaserver.representante.domain.dtos.RepresentanteCreateDto;
import com.senasa.tupaserver.representante.domain.dtos.RepresentanteFindDto;
import com.senasa.tupaserver.representante.domain.dtos.RepresentanteListDto;
import com.senasa.tupaserver.representante.domain.dtos.RepresentantePaginateDto;
import com.senasa.tupaserver.shared.sql.PaginateResponse;

public interface RepresentanteRepository {
  public RepresentanteMapper findRepresentante(RepresentanteFindDto request);

  public List<RepresentanteMapper> listRepresentantes(RepresentanteListDto request);

  public PaginateResponse<RepresentanteMapper> paginateRepresentantes(RepresentantePaginateDto page) throws Exception;

  public void createRepresentante(RepresentanteCreateDto request) throws SQLException;
}
