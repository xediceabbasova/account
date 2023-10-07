package com.company.account.service;

import com.company.account.dto.CustomerDTO;
import com.company.account.dto.CustomerDTOConverter;
import com.company.account.exception.CustomerNotFoundException;
import com.company.account.model.Customer;
import com.company.account.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerDTOConverter converter;

    public CustomerService(CustomerRepository customerRepository, CustomerDTOConverter converter) {
        this.customerRepository = customerRepository;
        this.converter = converter;
    }

    protected Customer findCustomerById(String id) {
        return customerRepository.findById(id)
                .orElseThrow(
                        () -> new CustomerNotFoundException("Customer could not find by id: " + id));
    }

    public CustomerDTO getCustomerById(String customerId) {
        return converter.convertToCustomerDTO(findCustomerById(customerId));
    }
}
