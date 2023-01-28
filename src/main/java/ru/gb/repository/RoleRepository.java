package ru.gb.repository;

import org.springframework.data.repository.CrudRepository;
import ru.gb.model.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
}
