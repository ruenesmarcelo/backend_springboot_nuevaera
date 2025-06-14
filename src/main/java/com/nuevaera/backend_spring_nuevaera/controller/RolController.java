package com.nuevaera.backend_spring_nuevaera.controller;


import com.nuevaera.backend_spring_nuevaera.model.Rol;
import com.nuevaera.backend_spring_nuevaera.repository.RolRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rol")
public class RolController{
    private final RolRepository rolRepo;

    public RolController(RolRepository rolRepo) {
        this.rolRepo = rolRepo;
    }

    // GET /api/rol  → devuelve todos los roles
    @GetMapping
    public List<Rol> getAllRoles() {
        return rolRepo.findAll();
    }

    // GET /api/rol/{id_rol}  → devuelve un rol por ID
    @GetMapping("/{id_rol}")
    public ResponseEntity<Rol> getRolById(@PathVariable int id_rol) {
        return rolRepo.findById(id_rol)
                .map(rol -> ResponseEntity.ok(rol))
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /api/rol  → crea un nuevo rol
    @PostMapping
    public ResponseEntity<Rol> createRol(@RequestBody Rol rol) {
        Rol saved = rolRepo.save(rol);
        return ResponseEntity.status(201).body(saved);
    }

    // PUT /api/rol/{id}  → actualiza un rol existente
    @PutMapping("/{id_rol}")
    public ResponseEntity<Rol> updateRol(
            @PathVariable int id_rol,
            @RequestBody Rol datosRol) {
        return rolRepo.findById(id_rol)
                .map(rol -> {
                    rol.setDescripcion(datosRol.getDescripcion());
                    Rol updated = rolRepo.save(rol);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE /api/rol/{id_rol}  → elimina un rol
    @DeleteMapping("/{id_rol}")
    public ResponseEntity<Void> deleteRol(@PathVariable int id_rol) {
        return rolRepo.findById(id_rol)
                .map(rol -> {
                    rolRepo.delete(rol);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}