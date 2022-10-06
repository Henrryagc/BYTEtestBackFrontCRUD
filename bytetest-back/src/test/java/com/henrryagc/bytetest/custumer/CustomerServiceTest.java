package com.henrryagc.bytetest.custumer;

import com.henrryagc.bytetest.db.model.CustomerEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;


class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    private CustomerService underTest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        underTest = new CustomerService(customerRepository);
    }

    @Test
    void putCustomer() {
        // Give
        var customerDTO = new CustomerDTO(
                1000L,
                "companyName",
                "contactName",
                "contactTitle",
                "address",
                "city",
                "region",
                5765757,
                "country",
                123123L,
                123123L
        );

        var customerEntity = new CustomerEntity(
                1000L,
                "companyName",
                "contactName",
                "contactTitle",
                "address",
                "city",
                "region",
                5765757,
                "country",
                123123L,
                123123L
        );

        given(customerRepository.getReferenceById(1000L)).willReturn(customerEntity);
        given(customerRepository.save(CustomerMapper.toCustomerEntity(customerDTO))).willReturn(customerEntity);
        // When
        Long actual;
        actual = underTest.putCustomer(1000L, customerDTO);
        System.out.printf("%s", actual);
        // Then

        var expected = 1L;
        assertThat(actual).isEqualTo(expected);

    }

    @Test
    void addCustomer() {
        // Give
        var customerEntity = CustomerEntity.builder()
                .companyName("companyName")
                .contactName("contactName")
                .contactTitle("contactTitle")
                .address("address")
                .city("city")
                .region("region")
                .phone(5765757L)
                .country("country")
                .fax(123123L)
                .postalCode(123123).build();

        // When
        customerRepository.save(customerEntity);

        // Then
        ArgumentCaptor<CustomerEntity> customerEntityArgumentCaptor=
        ArgumentCaptor.forClass(CustomerEntity.class);
        verify(customerRepository)
                .save(customerEntityArgumentCaptor.capture());
        var customerCaptured = customerEntityArgumentCaptor.getValue();
        assertThat(customerCaptured).isEqualTo(customerEntity);
    }
}