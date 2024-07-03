package com.senasa.tupaserver.methodPayment.application;

import java.util.List;

import javax.validation.Valid;

import com.senasa.tupaserver.methodPayment.domain.MethodPaymentRepository;
import com.senasa.tupaserver.methodPayment.domain.TypePaymentMapper;
import com.senasa.tupaserver.methodPayment.domain.dtos.TypePaymentListDto;

public class TypePaymentListService {
  public TypePaymentListService(MethodPaymentRepository methodPaymentRepository) {
    this.methodPaymentRepository = methodPaymentRepository;
  }

  MethodPaymentRepository methodPaymentRepository;

  public List<TypePaymentMapper> execute(@Valid TypePaymentListDto params) {
    return this.methodPaymentRepository.listTypePayments(params);
  }
}
