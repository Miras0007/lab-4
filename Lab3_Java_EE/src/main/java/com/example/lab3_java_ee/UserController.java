package com.example.lab3_java_ee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id) {
        User user = userService.getUserById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(404).body("Пользователь не найден");
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable int id, @RequestParam String name, @RequestParam int age) {
        User updatedUser = userService.updateUser(id, name, age);
        if(updatedUser != null) {
            return ResponseEntity.ok("Информация о пользователе обновлена: " + updatedUser);
        } else {
            return ResponseEntity.status(404).body("Пользователь не найден");
        }
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestParam int id, @RequestParam String name, @RequestParam int age) {
        User newUser = userService.createUser(id, name, age);
        return ResponseEntity.ok("Пользователь создан: " + newUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        boolean isDeleted = userService.deleteUserById(id);
        if (isDeleted) {
            return ResponseEntity.ok("Пользователь успешно удален");
        } else {
            return ResponseEntity.status(404).body("Пользователь не найден");
        }
    }
}
