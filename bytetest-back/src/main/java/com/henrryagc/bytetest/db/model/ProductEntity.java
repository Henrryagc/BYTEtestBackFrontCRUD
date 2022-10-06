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
@Table(name = "product_entity")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {
    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "product_sequence"
    )
    @Column(name = "productId", nullable = false)
    private Long productId;

    @Column(length = 80)
    private String productName;
    private Long quantityPerUnit;
    @Column(precision = 2)
    private Double unitPrice;
    private Long unitsInStock;
    private Long unitsOnOrder;
    @Column(precision = 2)
    private BigDecimal reorderLevel;
    private boolean discontinued;

    // private Long supplierId;
    @ManyToOne( cascade = {CascadeType.ALL})
    @JoinColumn(name = "supplier_id", referencedColumnName = "supplierId")
    private SupplierEntity supplier;
    // private Long categoryId;
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "category_id", referencedColumnName = "categoryId")
    private CategoryEntity category;
}