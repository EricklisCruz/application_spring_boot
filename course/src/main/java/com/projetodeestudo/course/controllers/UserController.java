package com.projetodeestudo.course.controllers;

import com.projetodeestudo.course.models.entities.User;
import com.projetodeestudo.course.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userServices;

    public UserController(UserService userServices) {
        this.userServices = userServices;
    }

    @GetMapping
    public ResponseEntity<List<User>> findAllUsers() {
        List<User> users = userServices.findAll();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findUserById(@PathVariable Integer id) {
        User user = userServices.findById(id);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/user")
    public ResponseEntity<User> insertUser(@RequestBody User user, UriComponentsBuilder uriComponentsBuilder) {
        user = userServices.insertUser(user);
        URI uri = uriComponentsBuilder.path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id) {
        userServices.delete(id);
        return ResponseEntity.noContent().build();
    }
}
