package com.nuevaera.backend_spring_nuevaera.repository;

import com.nuevaera.backend_spring_nuevaera.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    // Con JpaRepository ya tienes métodos como:
    // findAll(), findById(id), save(entity), deleteById(id), etc.
}
