package com.senasa.tupaserver.methodPayment.infrastructure.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.senasa.tupaserver.methodPayment.application.AccountListService;
import com.senasa.tupaserver.methodPayment.application.BankListService;
import com.senasa.tupaserver.methodPayment.application.TypePaymentListService;
import com.senasa.tupaserver.methodPayment.domain.AccountMapper;
import com.senasa.tupaserver.methodPayment.domain.BankMapper;
import com.senasa.tupaserver.methodPayment.domain.TypePaymentMapper;
import com.senasa.tupaserver.methodPayment.domain.dtos.AccountListDto;
import com.senasa.tupaserver.methodPayment.domain.dtos.BankListDto;
import com.senasa.tupaserver.methodPayment.domain.dtos.TypePaymentListDto;
import com.senasa.tupaserver.methodPayment.infrastructure.repository.MethodPaymentJpaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/methodPayments")
public class MethodPaymentHttpController {
  @Autowired
  MethodPaymentJpaRepository methodPaymentRepository;

  @GetMapping("/typePayments")
  public List<TypePaymentMapper> listTypePayments() {
    TypePaymentListService service = new TypePaymentListService(this.methodPaymentRepository);
    return service.execute(new TypePaymentListDto());
  }

  @GetMapping("/banks")
  public List<BankMapper> liskBanks() {
    BankListService service = new BankListService(this.methodPaymentRepository);
    return service.execute(new BankListDto());
  }

  @GetMapping("/banks/{id}/accounts")
  public List<AccountMapper> listAccounts(@PathVariable("id") String id) {
    AccountListDto request = new AccountListDto();
    request.setBankId(id);
    AccountListService service = new AccountListService(this.methodPaymentRepository);
    return service.execute(request);
  }
}
