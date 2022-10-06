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

import java.util.Date;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "employee_entity")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntity {
    @Id
    @SequenceGenerator(
            name = "employee_sequence",
            sequenceName = "employee_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "employee_sequence"
    )
    @Column(name = "employeeId", nullable = false)
    private Long employeeId;

    @Column(length = 80)
    private String lastName;
    @Column(length = 80)
    private String firstName;
    @Column(length = 80)
    private String title;
    @Column(length = 80)
    private String titleOfCourtesy;
    private Date birthDate;
    private Date hireDate;
    @Column(length = 80)
    private String address;
    @Column(length = 80)
    private String city;
    @Column(length = 80)
    private String region;
    private int postalCode;
    @Column(length = 80)
    private String country;
    private int homePhone;
    @Column(length = 80)
    private String extension;
    private String photo;
    private String notes;
    @Column(length = 120)
    private String reportsTo;
}