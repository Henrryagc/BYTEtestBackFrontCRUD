package com.henrryagc.bytetest.custumer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.*;

class CustomerServiceTesting {
    @Mock
    CustomerRepository customerRepository;
    @InjectMocks
    CustomerService customerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAllCustomers() {
        List<CustomerDTO> result = customerService.findAllCustomers();
        Assertions.assertEquals(List.of(new CustomerDTO(1L, "companyName", "contactName", "contactTitle", "address", "city", "region", 0, "country", 1L, 1L)), result);
    }

    @Test
    void testExistCustomerById() {
        boolean result = customerService.existCustomerById(1L);
        Assertions.assertTrue(result);
    }

    @Test
    void testAddCustomer() {
        Long result = customerService.addCustomer(new CustomerDTO(1L, "companyName", "contactName", "contactTitle", "address", "city", "region", 0, "country", 1L, 1L));
        Assertions.assertEquals(Long.valueOf(1), result);
    }

    @Test
    void testPutCustomer() {
        Long result = customerService.putCustomer(1L, new CustomerDTO(1L, "companyName", "contactName", "contactTitle", "address", "city", "region", 0, "country", 1L, 1L));
        Assertions.assertEquals(Long.valueOf(1), result);
    }

    @Test
    void testDeleteCustomer() {
        customerService.deleteCustomer(1L);
    }

    @Test
    void testAddManyCustomer() {
        int result = customerService.addManyCustomer(List.of(new CustomerDTO(1L, "companyName", "contactName", "contactTitle", "address", "city", "region", 0, "country", 1L, 1L)));
        Assertions.assertEquals(0, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme