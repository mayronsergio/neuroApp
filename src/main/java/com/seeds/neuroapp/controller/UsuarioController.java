package com.seeds.neuroapp.controller;

import com.seeds.neuroapp.model.Usuario;
import com.seeds.neuroapp.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsuarioController {

    private final UsuarioService usuarioService;

    UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @PostMapping("/usuarios")
    public Usuario salvarUsuario(@Valid @RequestBody Usuario usuario) throws Exception {
        return usuarioService.salvarUsuario(usuario);
    }

    @GetMapping("/usuarios/{id}")
    public Usuario consultarPorId(@PathVariable Long id){
        return usuarioService.consultarPorId(id);
    }

    @GetMapping("/usuarios")
    public List<Usuario> listarTodosUsuarios(){
        return usuarioService.consultarTodosUsuarios();
    }

    @PutMapping("/usuarios/{id}")
    public Usuario atualizarUsuario(@Valid @RequestBody Usuario usuario, @PathVariable Long id){
        return usuarioService.atualizarUsuario(usuario, id);
    }

    @DeleteMapping("/usuarios/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarUsuario(@PathVariable Long id){
        usuarioService.deletarUsuario(id);
    }
}
