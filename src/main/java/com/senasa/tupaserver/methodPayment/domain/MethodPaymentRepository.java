package com.senasa.tupaserver.methodPayment.domain;

import java.util.List;
import com.senasa.tupaserver.methodPayment.domain.dtos.AccountListDto;
import com.senasa.tupaserver.methodPayment.domain.dtos.BankListDto;
import com.senasa.tupaserver.methodPayment.domain.dtos.TypePaymentListDto;

public interface MethodPaymentRepository {
  public List<TypePaymentMapper> listTypePayments(TypePaymentListDto params);

  public List<BankMapper> listBanks(BankListDto params);

  public List<AccountMapper> listAccounts(AccountListDto params);
}
