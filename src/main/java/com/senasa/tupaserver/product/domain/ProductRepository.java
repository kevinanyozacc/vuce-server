package com.senasa.tupaserver.product.domain;

import com.senasa.tupaserver.product.domain.dtos.ProductListDto;
import com.senasa.tupaserver.product.domain.dtos.ProductPaginateDto;
import com.senasa.tupaserver.shared.sql.PaginateResponse;
import java.util.List;

public interface ProductRepository {
  public List<ProductMapper> listProducts(ProductListDto params) throws Exception;

  public PaginateResponse<ProductMapper> paginateProducts(ProductPaginateDto params) throws Exception;
}
