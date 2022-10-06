package com.henrryagc.bytetest.db.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

import java.util.Date;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "order_entity")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity {
    @Id
    @SequenceGenerator(
            name = "order_sequence",
            sequenceName = "order_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "order_sequence"
    )
    @Column(name = "orderId", nullable = false)
    private Long orderId;

    private Date orderDate;
    private Date requiredDate;
    private Date shippedDate;
    @Column(length = 80)
    private String shipVia;
    @Column(length = 80)
    private String freight;
    @Column(length = 80)
    private String shipName;
    @Column(length = 120)
    private String shipAddress;
    @Column(length = 80)
    private String shipCity;
    @Column(length = 80)
    private String shipRegion;
    private int shipPostalCode;
    @Column(length = 80)
    private String shipCountry;

    // private Long customerId;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "customer_id", referencedColumnName = "customerId")
    private CustomerEntity customer;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "employee_id", referencedColumnName = "employeeId")
    private EmployeeEntity employee;
    // private Long EmployeeId;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "shipper_id", referencedColumnName = "shipperId")
    private ShipperEntity shipper;
}