package com.senasa.tupaserver.product.infrastructure.controllers;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.senasa.tupaserver.product.application.ProductSearchService;
import com.senasa.tupaserver.product.domain.ProductMapper;
import com.senasa.tupaserver.product.domain.dtos.ProductSearchDto;
import com.senasa.tupaserver.product.infrastructure.repository.ProductJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/products")
public class ProductHttpController {
  @Autowired
  ProductJpaRepository productRepository;

  @GetMapping("search/{column}/animal/{value}")
  public List<ProductMapper> searchAnimal(
      @PathVariable("column") String column,
      @PathVariable("value") String value) throws Exception {
    ProductSearchDto request = new ProductSearchDto();
    request.setType("01");
    request.setColumn(column);
    request.setValue(value);
    ProductSearchService service = new ProductSearchService(this.productRepository);
    return service.execute(request);
  }

  @GetMapping("search/{column}/subproduct/{value}")
  public List<ProductMapper> searchVegetal(
      @PathVariable("column") String column,
      @PathVariable("value") String value) throws Exception {
    ProductSearchDto request = new ProductSearchDto();
    request.setType("02");
    request.setColumn(column);
    request.setValue(value);
    ProductSearchService service = new ProductSearchService(this.productRepository);
    return service.execute(request);
  }
}
