package com.company.account.dto;

import com.company.account.model.Customer;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CustomerDTOConverter {

    private final CustomerAccountDTOConverter converter;

    public CustomerDTOConverter(CustomerAccountDTOConverter converter) {
        this.converter = converter;
    }

    public AccountCustomerDTO convertToAccountCustomer(Customer from) {
        if (from == null) {
            return new AccountCustomerDTO("", "", "");
        }
        return new AccountCustomerDTO(from.getId(),
                from.getName(),
                from.getSurname());
    }

    public CustomerDTO convertToCustomerDTO(Customer from) {
        return new CustomerDTO(
                from.getId(),
                from.getName(),
                from.getSurname(),
                from.getAccounts()
                        .stream()
                        .map(converter::convert)
                        .collect(Collectors.toSet())
        );
    }

}
