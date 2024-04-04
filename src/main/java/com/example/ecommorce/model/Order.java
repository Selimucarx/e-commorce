package com.example.ecommorce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order extends BaseEntity{
    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Cart cart;

    @OneToMany(mappedBy = "orders")
    private List<Product> products;
}
