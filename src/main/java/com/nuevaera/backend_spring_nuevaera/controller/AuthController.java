package com.nuevaera.backend_spring_nuevaera.controller;

import java.util.Map;
import java.util.Optional;

import com.nuevaera.backend_spring_nuevaera.security.JwtUtil;
import org.springframework.http.HttpStatus;
import com.nuevaera.backend_spring_nuevaera.model.User;
import org.springframework.http.HttpStatus;
import com.nuevaera.backend_spring_nuevaera.model.LoginRequest;
import com.nuevaera.backend_spring_nuevaera.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin(origins = "https://nuevaera-v9ts.vercel.app/")
@CrossOrigin(origins = {
        "https://nuevaera-v9ts.vercel.app",
        "http://localhost:4200"
})
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        Optional<User> user = userRepository.findByCorreoAndContrasena(request.getCorreo(), request.getContrasena());

        /* sin el token se veria así:
        if (user.isPresent()) {

            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario o contraseña incorrectos");
        }*/

        //Ahora con el token
        if (user.isPresent()) {
            User u = user.get();

            // Aquí generamos el token con el correo y el rol
            String token = jwtUtil.generateToken(u.getNombre(), String.valueOf(u.getId_rol()));

            // Enviamos token + usuario
            return ResponseEntity.ok(Map.of(
                    "token", token,
                    "user", u
            ));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("message", "Usuario o contraseña incorrectos"));
        }
    }
}
