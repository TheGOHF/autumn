package ru.bgpu.autumn.controllers;

import org.springframework.web.bind.annotation.*;
import ru.bgpu.autumn.models.User;
import ru.bgpu.autumn.repositories.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> getAll() {
        return userRepository.findAll();
    }
}