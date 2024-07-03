package com.senasa.tupaserver.methodPayment.infrastructure.repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.senasa.tupaserver.methodPayment.domain.AccountMapper;
import com.senasa.tupaserver.methodPayment.domain.BankMapper;
import com.senasa.tupaserver.methodPayment.domain.MethodPaymentRepository;
import com.senasa.tupaserver.methodPayment.domain.TypePaymentMapper;
import com.senasa.tupaserver.methodPayment.domain.dtos.AccountListDto;
import com.senasa.tupaserver.methodPayment.domain.dtos.BankListDto;
import com.senasa.tupaserver.methodPayment.domain.dtos.TypePaymentListDto;
import com.senasa.tupaserver.shared.sql.QueryBuilderSql;

@Service
public class MethodPaymentJpaRepository implements MethodPaymentRepository {
  @Autowired
  JdbcTemplate jdbcTemplate;

  @Override
  public List<TypePaymentMapper> listTypePayments(TypePaymentListDto params) {
    QueryBuilderSql queryBuilder = new QueryBuilderSql()
        .from("FINALBPM.TIPO_PAGO TP");
    return this.jdbcTemplate.query(queryBuilder.getSql(), (row, index) -> new TypePaymentMapper(row, index));
  }

  @Override
  public List<BankMapper> listBanks(BankListDto params) {
    QueryBuilderSql queryBuilder = new QueryBuilderSql()
        .from("FINALBPM.BANCO B");
    return this.jdbcTemplate.query(queryBuilder.getSql(), (row, index) -> new BankMapper(row, index));
  }

  @Override
  public List<AccountMapper> listAccounts(AccountListDto params) {
    QueryBuilderSql queryBuilder = new QueryBuilderSql()
        .from("FINALBPM.BANCO_CTA_CTE BC");
    // filters
    if (params.getBankId() != null) {
      String condition = "'" + params.getBankId() + "'";
      queryBuilder.andWhere("BC.CODIGO_BANCO = " + condition);
    }
    // response
    return this.jdbcTemplate.query(queryBuilder.getSql(), (row, index) -> new AccountMapper(row, index));
  }
}
