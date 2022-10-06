package com.henrryagc.bytetest.custumer;

import lombok.Builder;

@Builder
public record CustomerDTO (
        Long customerId,
        String companyName,
        String contactName,
        String contactTitle,
        String address,
        String city,
        String region,
        int postalCode,
        String country,
        Long phone,
        Long fax) {}
