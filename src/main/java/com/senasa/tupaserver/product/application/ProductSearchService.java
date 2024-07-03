package com.senasa.tupaserver.product.application;

import javax.validation.Valid;
import java.util.List;
import com.senasa.tupaserver.product.domain.ProductMapper;
import com.senasa.tupaserver.product.domain.ProductRepository;
import com.senasa.tupaserver.product.domain.dtos.ProductListDto;
import com.senasa.tupaserver.product.domain.dtos.ProductSearchDto;

public class ProductSearchService {
  public ProductSearchService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  ProductRepository productRepository;

  public List<ProductMapper> execute(@Valid ProductSearchDto params) throws Exception {
    ProductListDto request = new ProductListDto();
    request.setType(params.getType());
    // filters
    if (params.getColumn().equals("arancelariaId")) {
      request.setArancelariaId(params.getValue());
    } else if (params.getColumn().equals("scientificName")) {
      request.setScientificName(params.getValue());
    } else if (params.getColumn().equals("name")) {
      request.setName(params.getValue());
    } else {
      throw new Exception("La busqueda no está disponible");
    }
    // response
    return this.productRepository.listProducts(request);
  }
}
