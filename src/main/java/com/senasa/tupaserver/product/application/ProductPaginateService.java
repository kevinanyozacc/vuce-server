package com.senasa.tupaserver.product.application;

import javax.validation.Valid;
import com.senasa.tupaserver.product.domain.ProductMapper;
import com.senasa.tupaserver.product.domain.ProductRepository;
import com.senasa.tupaserver.product.domain.dtos.ProductPaginateDto;
import com.senasa.tupaserver.shared.sql.PaginateResponse;

public class ProductPaginateService {
  public ProductPaginateService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  ProductRepository productRepository;

  public PaginateResponse<ProductMapper> execute(@Valid ProductPaginateDto params) throws Exception {
    return this.productRepository.paginateProducts(params);
  }
}
