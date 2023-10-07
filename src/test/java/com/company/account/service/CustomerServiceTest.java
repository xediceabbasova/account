package com.company.account.service;

import com.company.account.dto.CustomerDTO;
import com.company.account.dto.CustomerDTOConverter;
import com.company.account.exception.CustomerNotFoundException;
import com.company.account.model.Customer;
import com.company.account.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class CustomerServiceTest {

    private CustomerService service;
    private CustomerRepository customerRepository;
    private CustomerDTOConverter converter;

    @BeforeEach
    public void setUp() {
        customerRepository = mock(CustomerRepository.class);
        converter = mock(CustomerDTOConverter.class);
        service = new CustomerService(customerRepository, converter);
    }

    @Test
    public void testFindByCustomerId_whenCustomerIdExists_shouldReturnCustomer() {
        Customer customer = new Customer("id", "name", "surname", Set.of());

        Mockito.when(customerRepository.findById("id")).thenReturn(Optional.of(customer));

        Customer result = service.findCustomerById("id");

        assertEquals(result, customer);

    }

    @Test
    public void testFindByCustomerId_whenCustomerIdDoesNotExists_shouldThrowCustomerNotFoundException() {

        Mockito.when(customerRepository.findById("id")).thenReturn(Optional.empty());
        assertThrows(CustomerNotFoundException.class, () -> service.findCustomerById("id"));
    }

    @Test
    public void testGetCustomerById_whenCustomerIdExists_shouldReturnCustomer() {
        Customer customer = new Customer("id", "name", "surname", Set.of());
        CustomerDTO customerDTO = new CustomerDTO("id", "name", "surname", Set.of());

        Mockito.when(customerRepository.findById("id")).thenReturn(Optional.of(customer));
        Mockito.when(converter.convertToCustomerDTO(customer)).thenReturn(customerDTO);


        CustomerDTO result = service.getCustomerById("id");

        assertEquals(result, customerDTO);

    }

    @Test
    public void testGetCustomerById_whenCustomerIdDoestNotExist_shouldThrowCustomerNotFoundException(){

        Mockito.when(customerRepository.findById("id")).thenReturn(Optional.empty());
        assertThrows(CustomerNotFoundException.class, () -> service.getCustomerById("id"));

        Mockito.verifyNoInteractions(converter);
    }


}