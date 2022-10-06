package com.henrryagc.bytetest.custumer;

import com.henrryagc.bytetest.db.model.CustomerEntity;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerMapper {
    public static CustomerEntity toCustomerEntity(CustomerDTO customerDTO) {
        if (customerDTO == null) {
            return null;
        }
        return CustomerEntity.builder()
                .customerId(customerDTO.customerId())
                .companyName(customerDTO.companyName())
                .contactName(customerDTO.contactName())
                .contactTitle(customerDTO.contactTitle())
                .address(customerDTO.address())
                .city(customerDTO.city())
                .region(customerDTO.region())
                .postalCode(customerDTO.postalCode())
                .country(customerDTO.country())
                .phone(customerDTO.phone())
                .fax(customerDTO.fax())
                .build();
    }

    public static CustomerDTO toCustomerDTO(CustomerEntity customerEntity) {
        if (customerEntity == null) {
            return null;
        }
        return CustomerDTO.builder()
                .companyName(customerEntity.getCompanyName())
                .contactName(customerEntity.getContactName())
                .build();
    }

    public static List<CustomerDTO> toCustomerDTOList(List<CustomerEntity> customerEntityList) {
        if (customerEntityList == null) {
            return null;
        }

        return customerEntityList.stream().map(
                customerEntity -> CustomerDTO.builder()
                        .customerId(customerEntity.getCustomerId())
                        .companyName(customerEntity.getCompanyName())
                        .contactName(customerEntity.getContactName())
                        .contactTitle(customerEntity.getContactTitle())
                        .address(customerEntity.getAddress())
                        .city(customerEntity.getCity())
                        .region(customerEntity.getRegion())
                        .postalCode(customerEntity.getPostalCode())
                        .country(customerEntity.getCountry())
                        .phone(customerEntity.getPhone())
                        .fax(customerEntity.getFax())
                        .build())
                .collect(Collectors.toList());
    }

    public static CustomerEntity toUpdateCustomerEntity(CustomerEntity customerEntityExist, CustomerDTO customerDTO) {
        customerEntityExist.setCompanyName((customerDTO.companyName() != null) ? customerDTO.companyName() : customerEntityExist.getCompanyName());
        customerEntityExist.setContactName((customerDTO.contactName() != null) ? customerDTO.contactName() : customerEntityExist.getContactName());
        customerEntityExist.setContactTitle((customerDTO.contactTitle() != null) ? customerDTO.contactTitle() : customerEntityExist.getContactTitle());
        customerEntityExist.setAddress((customerDTO.address() != null) ? customerDTO.address() : customerEntityExist.getAddress());
        customerEntityExist.setCity((customerDTO.city() != null) ? customerDTO.city() : customerEntityExist.getCity());
        customerEntityExist.setRegion((customerDTO.region() != null) ? customerDTO.region() : customerEntityExist.getRegion());
        customerEntityExist.setPostalCode((customerDTO.postalCode() < 0) ? customerEntityExist.getPostalCode() : customerDTO.postalCode());
        customerEntityExist.setCountry((customerDTO.country() != null) ? customerDTO.country() : customerEntityExist.getCountry());
        customerEntityExist.setPhone((customerDTO.phone() != null) ? customerDTO.phone() : customerEntityExist.getPhone());
        customerEntityExist.setFax((customerDTO.fax() != null) ? customerDTO.fax() : customerEntityExist.getFax());
        return customerEntityExist;
    }

    public static List<CustomerEntity> toSaveCustomerEntityList(List<CustomerDTO> customerDTOList) {
        return customerDTOList.stream().map(CustomerMapper::toCustomerEntity).toList();
    }
}
