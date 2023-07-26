package com.projetodeestudo.course.service;

import com.projetodeestudo.course.models.entities.User;
import com.projetodeestudo.course.repositories.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Integer id) {
        return userRepository.findById(id).orElseThrow(() ->
                new RuntimeException("User not found!!"));
    }

    public User insertUser(User user) {
        return userRepository.save(user);
    }

    public void delete(Integer id) {
        User user = userRepository.getReferenceById(id);
        userRepository.delete(user);

    }

    public User update(Integer id, User user) {
        User entity = userRepository.getReferenceById(id);
        updateData(entity, user);
        return userRepository.save(entity);
    }

    private void updateData(User entity, User user) {
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPhone(user.getPhone());
    }
}
