package com.senasa.tupaserver.methodPayment.application;

import java.util.List;
import javax.validation.Valid;
import com.senasa.tupaserver.methodPayment.domain.BankMapper;
import com.senasa.tupaserver.methodPayment.domain.MethodPaymentRepository;
import com.senasa.tupaserver.methodPayment.domain.dtos.BankListDto;

public class BankListService {
  public BankListService(MethodPaymentRepository methodPaymentRepository) {
    this.methodPaymentRepository = methodPaymentRepository;
  }

  MethodPaymentRepository methodPaymentRepository;

  public List<BankMapper> execute(@Valid BankListDto params) {
    return this.methodPaymentRepository.listBanks(params);
  }
}
