package com.example.ecommorce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "carts")
public class Cart extends BaseEntity{
    @OneToOne
    private Customer customer;

    @OneToMany(mappedBy = "cart")
    private List<Product> products;

    @OneToOne
    private Order orders;
}
