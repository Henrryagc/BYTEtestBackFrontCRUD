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
@Table(name = "suppliers_entity")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SupplierEntity {
    @Id
    @SequenceGenerator(
            name = "supplier_sequence",
            sequenceName = "supplier_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "supplier_sequence"
    )
    @Column(name = "supplierId", nullable = false)
    private Long supplierID;
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
    @Column(length = 80)
    private String postalCode;
    @Column(length = 80)
    private String country;
    private Long phone;
    private Long fax;
    @Column(length = 80)
    private String homePage;
}
