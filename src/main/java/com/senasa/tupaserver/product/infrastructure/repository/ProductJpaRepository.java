package com.senasa.tupaserver.product.infrastructure.repository;

import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.senasa.tupaserver.product.domain.ProductMapper;
import com.senasa.tupaserver.product.domain.ProductRepository;
import com.senasa.tupaserver.product.domain.dtos.ProductListDto;
import com.senasa.tupaserver.product.domain.dtos.ProductPaginateDto;
import com.senasa.tupaserver.product.infrastructure.repository.jdbc.ProductSelectJdbc;
import com.senasa.tupaserver.shared.sql.PaginateMeta;
import com.senasa.tupaserver.shared.sql.PaginateResponse;
import com.senasa.tupaserver.shared.sql.PaginateSql;
import com.senasa.tupaserver.shared.sql.QueryBuilderSql;

@Service
public class ProductJpaRepository implements ProductRepository {
  @Autowired
  ModelMapper modelMapper;

  @Autowired
  JdbcTemplate jdbcTemplate;

  @Override
  public PaginateResponse<ProductMapper> paginateProducts(ProductPaginateDto params) throws Exception {
    List<ProductMapper> items = new ArrayList<ProductMapper>();
    PaginateMeta meta = new PaginateMeta();
    PageRequest page = PageRequest.of(params.getPage(), params.getLimit());
    ProductListDto request = this.modelMapper.map(params, ProductListDto.class);
    QueryBuilderSql queryBuilder = new ProductSelectJdbc().query(request);
    PaginateSql<ProductMapper> paginate = new PaginateSql<ProductMapper>(this.jdbcTemplate, queryBuilder);
    paginate.execute(page);
    System.out.println(paginate.getTotal());
    // validar total
    if (paginate.getTotal() == 0) {
      return new PaginateResponse<ProductMapper>(meta, items);
    }
    // obtener data
    items = this.jdbcTemplate.query(paginate.getSqlData(), (row, index) -> new ProductMapper(row, index));
    meta = new PaginateMeta((PageRequest) page, items.size(), paginate.getTotal());
    return new PaginateResponse<ProductMapper>(meta, items);
  }

  @Override
  public List<ProductMapper> listProducts(ProductListDto params) throws Exception {
    QueryBuilderSql queryBuilder = new ProductSelectJdbc().query(params);
    return this.jdbcTemplate.query(queryBuilder.getSql(), (row, index) -> new ProductMapper(row, index));
  }
}
