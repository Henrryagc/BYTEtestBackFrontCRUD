package com.henrryagc.bytetest.db.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.math.BigDecimal;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "order_detail_entity")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailEntity {
    @Id
    @SequenceGenerator(
            name = "order_details_sequence",
            sequenceName = "order_details_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "order_details_sequence"
    )
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(precision = 2)
    private BigDecimal unitPrice;
    private BigDecimal quantity;
    @Column(precision = 2)
    private BigDecimal discount;

    @ManyToOne(fetch = FetchType.EAGER,
            cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "product_id", referencedColumnName = "productId")
    private ProductEntity product;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "order_id", referencedColumnName = "orderId")
    private OrderEntity order;
}