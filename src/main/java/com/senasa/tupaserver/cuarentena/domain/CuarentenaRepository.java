package com.senasa.tupaserver.cuarentena.domain;

import java.sql.SQLException;
import java.util.List;
import com.senasa.tupaserver.cuarentena.domain.dtos.CuarentenaCreateDto;
import com.senasa.tupaserver.cuarentena.domain.dtos.CuarentenaListDto;
import com.senasa.tupaserver.shared.sql.TransctionSql;

public interface CuarentenaRepository extends TransctionSql {

  public CuarentenaEntity createCuarentena(CuarentenaCreateDto params) throws SQLException;

  public List<CuarentenaMapper> listCuarentenas(CuarentenaListDto params);

  public boolean deleteCuarentenas(CuarentenaListDto params) throws SQLException;
}
