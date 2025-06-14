package com.nuevaera.backend_spring_nuevaera.controller;

import com.nuevaera.backend_spring_nuevaera.model.User;
import com.nuevaera.backend_spring_nuevaera.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserRepository userRepo;

    public UserController(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    // GET /api/usuarios  → devuelve todos los usuarios
    @GetMapping
    public List<User> getAllUsuarios() {
        return userRepo.findAll();
    }

    // GET /api/usuarios/{id}  → devuelve un usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUsuarioById(@PathVariable String id) {
        return userRepo.findById(id)
                .map(user -> ResponseEntity.ok(user))
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /api/usuarios  → crea un nuevo usuario
    @PostMapping
    public ResponseEntity<User> createUsuario(@RequestBody User user) {
        // Aquí podrías validar campos (nombre, email) antes de guardar
        User saved = userRepo.save(user);
        return ResponseEntity.status(201).body(saved);
    }

    // PUT /api/usuarios/{id}  → actualiza un usuario existente
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUsuario(
            @PathVariable String id,
            @RequestBody User datosUsuario) {
        return userRepo.findById(id)
                .map(user -> {
                    user.setNombre(datosUsuario.getNombre());
                    user.setApellido(datosUsuario.getApellido());
                    user.setId_rol(datosUsuario.getId_rol());
                    user.setCorreo(datosUsuario.getCorreo());
                    user.setTelefono(datosUsuario.getTelefono());
                    user.setDireccion(datosUsuario.getDireccion());
                    user.setContrasena(datosUsuario.getContrasena());
                    User updated = userRepo.save(user);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE /api/usuarios/{id}  → elimina un usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        return userRepo.findById(id)
                .map(user -> {
                    userRepo.delete(user);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
