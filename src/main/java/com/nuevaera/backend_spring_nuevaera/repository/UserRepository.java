package com.nuevaera.backend_spring_nuevaera.repository;

import com.nuevaera.backend_spring_nuevaera.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    // Con JpaRepository ya tienes métodos como:
    // findAll(), findById(id), save(entity), deleteById(id), etc.
}
