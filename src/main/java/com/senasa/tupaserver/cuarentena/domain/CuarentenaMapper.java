package com.senasa.tupaserver.cuarentena.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.senasa.tupaserver.product.domain.ProductMapper;
import com.senasa.tupaserver.ubigeo.domain.PaisMapper;

public class CuarentenaMapper extends CuarentenaEntity {
  public CuarentenaMapper(ResultSet rs, int index) throws SQLException {
    this.setId(rs.getString("CODIGO_CUARENTENA_PRODUCTO"));
    this.setSecuencia(rs.getInt("SECUENCIAL_PRODUCTO"));
    this.setExpedienteId(rs.getString("CODIGO_EXPEDIENTE"));
    this.setProductId(rs.getString("CODIGO_PRODUCTO"));
    this.setWeight(rs.getString("PESO_PRODUCTO"));
    this.setGender(rs.getString("SEXO_PRODUCTO"));
    this.setAge(rs.getInt("EDAD_PRODUCTO"));
    this.setAmount(rs.getDouble("CANTIDAD_PRODUCTO"));
    this.setAuthorization(rs.getString("AUTORIZACION_PRODUCTO"));
    this.setPaisId(rs.getString("PAIS_ID"));
    this.setType(rs.getString("TIPO_PRODUCTO"));
    // validar pais
    if (this.getPaisId() != null) {
      this.pais = new PaisMapper();
      this.pais.setId(rs.getString("PAIS_ID"));
      this.pais.setName(rs.getString("NOMB_PAIS_TPA"));
    }
    // validar product
    if (this.getProductId() != null) {
      this.product = new ProductMapper();
      this.product.setId(rs.getString("CODIGO_PRODUCTO"));
      this.product.setType(rs.getString("CODIGO_CLASE"));
      this.product.setName(rs.getString("NOMBRE_COMERCIAL_PRODUCTO"));
      this.product.setScientificName(rs.getString("NOMBRE_CIENTIFICO_PRODUCTO"));
      this.product.setArancelariaId(rs.getString("CODIGO_PARTIDA_ARANCELARIA"));
      this.product.setArancelariaPartida(rs.getString("PARTIDA_ARANCELARIA"));
      this.product.setArancelariaName(rs.getString("DESCRIPCION_PART_ARANCELARIA"));
      this.product.setState(rs.getString("ESTADO_PRODUCTO"));
    }
  }

  private PaisMapper pais;
  private ProductMapper product;

  public PaisMapper getPais() {
    return this.pais;
  }

  public void setPais(PaisMapper value) {
    this.pais = value;
  }

  public ProductMapper getProduct() {
    return this.product;
  }

  public void setProduct(ProductMapper value) {
    this.product = value;
  }
}
