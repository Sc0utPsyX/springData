package ru.gb.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.gb.model.User;
import ru.gb.service.UserService;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final UserService userService;

    @GetMapping("/")
    public String homePage() {
        return "index.html";
    }

    @GetMapping("/manager")
    public String managerPage() {
        return "manager.html";
    }


    @GetMapping("/admin")
    @ResponseBody
    public String adminPage() {
        return "admin";
    }

    @GetMapping("/users")
    public String testPage() {
        return "userlist.html";
    }
}
