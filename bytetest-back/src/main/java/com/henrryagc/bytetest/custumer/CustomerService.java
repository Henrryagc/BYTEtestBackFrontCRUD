package com.henrryagc.bytetest.custumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Transactional(readOnly = true)
    public List<CustomerDTO> findAllCustomers() {
        return CustomerMapper.toCustomerDTOList(customerRepository.findAll());
    }

    @Transactional(readOnly = true)
    public boolean existCustomerById(Long customerId) {
        return customerRepository.findById(customerId).isPresent();
    }

    @Transactional
    public Long addCustomer(CustomerDTO customerDTO) {

        return customerRepository
                .save(CustomerMapper.toCustomerEntity(customerDTO))
                .getCustomerId();
    }

    @Transactional
    public Long putCustomer(Long id, CustomerDTO customerDTO) {
        var customerExist = customerRepository.getReferenceById(id);
        return customerRepository
                .save(CustomerMapper.toUpdateCustomerEntity(customerExist, customerDTO))
                .getCustomerId();
    }

    @Transactional
    public void deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
    }

    public int addManyCustomer(List<CustomerDTO> customerDTOList) {
        var obj = customerRepository.saveAll(CustomerMapper.toSaveCustomerEntityList(customerDTOList));
        return obj.size();
    }
}
