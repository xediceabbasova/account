package com.company.account.service;

import com.company.account.dto.AccountDTO;
import com.company.account.dto.AccountDTOConverter;
import com.company.account.dto.CreateAccountRequest;
import com.company.account.model.Account;
import com.company.account.model.Customer;
import com.company.account.model.Transaction;
import com.company.account.repository.AccountRepository;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.function.Supplier;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final CustomerService customerService;
    private final AccountDTOConverter accountDTOConverter;


    public AccountService(AccountRepository accountRepository,
                          CustomerService customerService,
                          AccountDTOConverter accountDTOConverter) {
        this.accountRepository = accountRepository;
        this.customerService = customerService;
        this.accountDTOConverter = accountDTOConverter;

    }

    public AccountDTO createAccount(CreateAccountRequest createAccountRequest) {

        Customer customer = customerService.findCustomerById(createAccountRequest.getCustomerId());
        Account account = new Account(
                customer,
                createAccountRequest.getInitialCredit(),
                LocalDateTime.now()
        );

        if (createAccountRequest.getInitialCredit().compareTo(BigDecimal.ZERO) > 0) {
            Transaction transaction = new Transaction(createAccountRequest.getInitialCredit(), account);
            account.getTransaction().add(transaction);
        }

        return accountDTOConverter.convert(accountRepository.save(account));

    }

}
