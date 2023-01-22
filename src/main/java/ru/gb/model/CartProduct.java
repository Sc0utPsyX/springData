package ru.gb.model;


import jakarta.persistence.*;
import lombok.Data;



@Data
@Entity
public class CartProduct {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "count", nullable = false)
    private Integer count;


    public CartProduct() {
    }

    public CartProduct(Product product, Integer count) {
        this.product = product;
        this.count = count;
    }

}
