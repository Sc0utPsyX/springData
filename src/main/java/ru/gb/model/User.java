package ru.gb.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;

@Entity
@Data
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", roles=" + roles +
                '}' + "\n";
    }

    public User() {
    }

    @ManyToMany
    @JoinTable(name = "users_roles",
                joinColumns = @JoinColumn(name = "userid"),
                inverseJoinColumns = @JoinColumn(name = "roleid"))
    private Collection<Role> roles;
}
