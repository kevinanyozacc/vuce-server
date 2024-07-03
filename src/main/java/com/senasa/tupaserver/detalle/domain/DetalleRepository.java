package com.senasa.tupaserver.detalle.domain;

import java.sql.SQLException;
import com.senasa.tupaserver.detalle.domain.dtos.DetalleCreateDto;
import com.senasa.tupaserver.detalle.domain.dtos.DetalleFindDto;
import com.senasa.tupaserver.shared.sql.TransctionSql;

public interface DetalleRepository extends TransctionSql {

  public DetalleMapper findDetalle(DetalleFindDto params);

  public DetalleEntity createDetalle(DetalleCreateDto params) throws SQLException;
}
