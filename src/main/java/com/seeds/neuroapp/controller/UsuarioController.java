package com.seeds.neuroapp.controller;

import com.seeds.neuroapp.model.Usuario;
import com.seeds.neuroapp.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public Usuario salvarUsuario(@Valid @RequestBody Usuario usuario) throws Exception {
        return usuarioService.salvarUsuario(usuario);
    }

    @GetMapping("/{id}")
    public Usuario consultarPorId(@PathVariable Long id){
        return usuarioService.consultarUsuarioPorId(id);
    }

    @GetMapping
    public List<Usuario> listarTodosUsuarios(){
        return usuarioService.consultarTodosUsuarios();
    }

    @PutMapping("/{id}")
    public Usuario atualizarUsuario(@Valid @RequestBody Usuario usuario, @PathVariable Long id){
        return usuarioService.atualizarUsuario(usuario, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarUsuario(@PathVariable Long id){
        usuarioService.deletarUsuario(id);
    }
}
