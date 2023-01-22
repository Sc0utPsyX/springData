package ru.gb.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "carts")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<CartProduct> productList;

    public Cart(Customer customer){
        this.customer = customer;
    }

    public Cart() {
    }
}







