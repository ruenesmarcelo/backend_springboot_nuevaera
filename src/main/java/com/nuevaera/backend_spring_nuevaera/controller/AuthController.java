package com.nuevaera.backend_spring_nuevaera.controller;

import java.util.Optional;
import org.springframework.http.HttpStatus;
import com.nuevaera.backend_spring_nuevaera.model.User;
import org.springframework.http.HttpStatus;
import com.nuevaera.backend_spring_nuevaera.model.LoginRequest;
import com.nuevaera.backend_spring_nuevaera.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        Optional<User> user = userRepository.findByCorreoAndContrasena(request.getCorreo(), request.getContrasena());

        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario o contraseña incorrectos");
        }
    }
}
