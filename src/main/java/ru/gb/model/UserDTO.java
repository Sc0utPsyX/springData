package ru.gb.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;

@Data
public class UserDTO {
    private Long id;
    private String username;
    private Collection<Role> roles;

    public UserDTO(Long id, String username, Collection<Role> roles) {
        this.id = id;
        this.username = username;
        this.roles = roles;
    }
}
