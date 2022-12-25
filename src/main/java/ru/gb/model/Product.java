package ru.gb.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "cost")
    private Double cost;

    public Product() {
    }

    public Product(String title, Double cost) {
        this.title = title;
        this.cost = cost;
    }
}
