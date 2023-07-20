package com.projetodeestudo.course.repositories;

import com.projetodeestudo.course.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
