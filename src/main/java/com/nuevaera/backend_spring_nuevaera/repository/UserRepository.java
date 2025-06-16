package com.nuevaera.backend_spring_nuevaera.repository;

import java.util.Optional;
import com.nuevaera.backend_spring_nuevaera.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByCorreoAndContrasena(String correo, String contrasena);
    // Con JpaRepository ya tienes métodos como:
    // findAll(), findById(id), save(entity), deleteById(id), etc.
}
