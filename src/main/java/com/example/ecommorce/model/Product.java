package com.example.ecommorce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product extends BaseEntity{
    @Column(name = "product_name",length = 100,nullable = false)
    private String name;
    @Column(name = "product_stock",length = 100,nullable = false)
    private  int stock;
    @Column(name = "product_price",length = 100,nullable = false,scale = 2)
    private BigDecimal price;
    @Column(name = "product_description",length = 100,nullable = false)
    private String description;
}
