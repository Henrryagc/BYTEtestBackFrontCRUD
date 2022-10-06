package com.henrryagc.bytetest.db.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "shipper_entity")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShipperEntity {
    @Id
    @SequenceGenerator(
            name = "shipper_sequence",
            sequenceName = "shipper_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "shipper_sequence"
    )
    @Column(name = "shipperId", nullable = false)
    private Long shipperId;

    @Column(length = 80)
    private String companyName;
    private Long phone;
}