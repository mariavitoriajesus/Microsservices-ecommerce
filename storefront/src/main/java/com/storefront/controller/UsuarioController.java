package com.storefront.controller;

import com.storefront.model.Usuario;
import com.storefront.service.UsuarioService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    public Usuario create(@RequestBody Usuario usuario) {
        return service.save(usuario);
    }

    @GetMapping
    public List<Usuario> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Usuario findById(@PathVariable Long id) {
        return service.findById(id).orElseThrow();
    }
}
