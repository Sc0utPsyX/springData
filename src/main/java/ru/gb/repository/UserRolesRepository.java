package ru.gb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.model.UserRoles;

import java.util.List;

public interface UserRolesRepository extends JpaRepository<UserRoles, Long> {
    List<UserRoles> findAllByUserid(Long id);
}
