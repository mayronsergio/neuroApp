package com.seeds.neuroapp.controller;

import com.seeds.neuroapp.model.Usuario;
import com.seeds.neuroapp.service.UsuarioService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UsuarioController {

    private final UsuarioService usuarioService;

    UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @PostMapping("/usuarios")
    public Usuario salvarUsuario(@RequestBody Usuario usuario) throws Exception {
        return usuarioService.salvarUsuario(usuario);
    }
}
