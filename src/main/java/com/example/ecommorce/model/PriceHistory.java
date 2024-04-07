package com.example.ecommorce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "price_history")
public class PriceHistory extends BaseEntity{
    @ManyToOne
    private Product product;

    private BigDecimal price;

    private BigDecimal orderItemPrice;
}
