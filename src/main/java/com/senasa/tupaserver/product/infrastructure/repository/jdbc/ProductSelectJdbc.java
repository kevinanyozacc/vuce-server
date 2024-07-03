package com.senasa.tupaserver.product.infrastructure.repository.jdbc;

import com.senasa.tupaserver.product.domain.dtos.ProductListDto;
import com.senasa.tupaserver.shared.sql.QueryBuilderSql;

public class ProductSelectJdbc {
  public QueryBuilderSql query(ProductListDto params) {
    QueryBuilderSql queryBuilder = new QueryBuilderSql().from("FINALBPM.PRODUCTO P")
        .innerJoin("FINALBPM.PARTIDA_ARANCELARIA PA", "PA.CODIGO_PARTIDA_ARANCELARIA = P.CODIGO_PARTIDA_ARANCELARIA")
        .leftJoin("SIGSVE.CATALOGO_ESPECIE_SINONIMO E", "E.CODIGO_ESPECIE = P.CODIGO_ESPECIE")
        .select("P.*")
        .addSelect("PA.CODIGO_PARTIDA_ARANCELARIA", "CODIGO_PARTIDA_ARANCELARIA")
        .addSelect("PA.DESCRIPCION_PART_ARANCELARIA", "DESCRIPCION_PART_ARANCELARIA")
        .addSelect("PA.PARTIDA_ARANCELARIA", "PARTIDA_ARANCELARIA")
        .addSelect("E.NOMB_SINO_SIN", "NOMB_SINO_SIN");
    // filters
    if (params.getType() != null) {
      String condition = "UPPER('" + params.getType() + "')";
      queryBuilder.andWhere("UPPER(P.CODIGO_CLASE) LIKE " + condition);
    }
    if (params.getName() != null) {
      String condition = "UPPER('%" + params.getName() + "%')";
      queryBuilder.andWhere("UPPER(P.NOMBRE_COMERCIAL_PRODUCTO) LIKE " + condition);
    }
    if (params.getScientificName() != null) {
      String condition = "UPPER('%" + params.getScientificName() + "%')";
      queryBuilder.andWhere("UPPER(P.NOMBRE_CIENTIFICO_PRODUCTO) LIKE " + condition);
    }
    if (params.getArancelariaId() != null) {
      String condition = "UPPER('%" + params.getArancelariaId() + "%')";
      queryBuilder.andWhere("UPPER(P.CODIGO_PARTIDA_ARANCELARIA) LIKE " + condition);
    }
    // response
    return queryBuilder;
  }
}
