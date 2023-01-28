package ru.gb.service;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.gb.model.Role;
import ru.gb.model.User;
import ru.gb.model.UserRoles;
import ru.gb.repository.RoleRepository;
import ru.gb.repository.UserRepository;
import ru.gb.repository.UserRolesRepository;


@Component
@RequiredArgsConstructor
public class UserDataGenerator {
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final UserRolesRepository userRolesRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void generateDataOnStartup() {
        roleRepository.save(new Role("ROLE_USER"));
        roleRepository.save(new Role("ROLE_MANAGER"));
        roleRepository.save(new Role("ROLE_ADMIN"));
        roleRepository.save(new Role("ROLE_SADMIN"));
        userRepository.save(new User("user", "$2y$10$FzJtdaHdqr/VcNBAig1zV.e06vxcnz9DUSLFQxqg1JLDq1t9Guk5G"));
        userRepository.save(new User("manager", "$2y$10$FzJtdaHdqr/VcNBAig1zV.e06vxcnz9DUSLFQxqg1JLDq1t9Guk5G"));
        userRepository.save(new User("admin", "$2y$10$FzJtdaHdqr/VcNBAig1zV.e06vxcnz9DUSLFQxqg1JLDq1t9Guk5G"));
        userRepository.save(new User("sadmin", "$2y$10$FzJtdaHdqr/VcNBAig1zV.e06vxcnz9DUSLFQxqg1JLDq1t9Guk5G"));
        userRolesRepository.save(new UserRoles(1L,1L));
        userRolesRepository.save(new UserRoles(2L,1L));
        userRolesRepository.save(new UserRoles(2L,2L));
        userRolesRepository.save(new UserRoles(3L,1L));
        userRolesRepository.save(new UserRoles(3L,2L));
        userRolesRepository.save(new UserRoles(3L,3L));
        userRolesRepository.save(new UserRoles(4L,1L));
        userRolesRepository.save(new UserRoles(4L,2L));
        userRolesRepository.save(new UserRoles(4L,3L));
        userRolesRepository.save(new UserRoles(4L,4L));

    }
}
