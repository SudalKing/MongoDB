package com.sudal.mongodb.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;

    @PostMapping("")
    public String create(@RequestParam String name) {
        return userService.create(name);
    }

    @GetMapping("")
    public User read(String id) {
        return userService.read(id);
    }

    @PutMapping("")
    public User update(String id, String name) {
        return userService.update(id, name);
    }

    @DeleteMapping("")
    public void delete(String id) {
        userService.delete(id);
    }
}
