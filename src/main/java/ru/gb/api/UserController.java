package ru.gb.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gb.model.UserDTO;
import ru.gb.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<UserDTO> getAll() {
        return userService.getAll()
                .stream()
                .map((user) -> new UserDTO(user.getId(), user.getUsername(), user.getRoles()))
                .toList();
    }

}
