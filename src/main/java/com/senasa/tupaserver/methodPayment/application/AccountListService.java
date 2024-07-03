package com.senasa.tupaserver.methodPayment.application;

import java.util.List;
import javax.validation.Valid;
import com.senasa.tupaserver.methodPayment.domain.AccountMapper;
import com.senasa.tupaserver.methodPayment.domain.MethodPaymentRepository;
import com.senasa.tupaserver.methodPayment.domain.dtos.AccountListDto;

public class AccountListService {
  public AccountListService(MethodPaymentRepository methodPaymentRepository) {
    this.methodPaymentRepository = methodPaymentRepository;
  }

  MethodPaymentRepository methodPaymentRepository;

  public List<AccountMapper> execute(@Valid AccountListDto params) {
    return this.methodPaymentRepository.listAccounts(params);
  }
}
