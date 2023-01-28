package ru.gb.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;

@Entity
@Data
@Table(name="roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    public Role(String name) {
        this.name = name;
    }

    public Role() {

    }
}
