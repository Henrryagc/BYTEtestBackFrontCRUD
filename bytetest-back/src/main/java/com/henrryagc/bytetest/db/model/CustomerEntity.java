package com.henrryagc.bytetest.db.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "customer_entity")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerEntity {

    @Id
    @SequenceGenerator(
            name = "customer_sequence",
            sequenceName = "customer_sequence",
            allocationSize = 1,
            initialValue = 1000
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "customer_sequence"
    )
    @Column(name = "customerId", nullable = false)
    private Long customerId;

    @Column(length = 80)
    private String companyName;
    @Column(length = 80)
    private String contactName;
    @Column(length = 80)
    private String contactTitle;
    @Column(length = 120)
    private String address;
    @Column(length = 80)
    private String city;
    @Column(length = 80)
    private String region;
    private int postalCode;
    @Column(length = 80)
    private String country;
    private Long phone;
    private Long fax;
}