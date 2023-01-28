package ru.gb.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="users_roles")
public class UserRoles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "userid")
        private Long userid;

        @Column(name = "roleid")
        private Long roleid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserRoles(Long user_id, Long role_id) {
        this.userid = user_id;
        this.roleid = role_id;
    }

    public UserRoles() {
    }
}
