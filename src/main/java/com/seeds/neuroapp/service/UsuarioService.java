package com.seeds.neuroapp.service;

import com.seeds.neuroapp.model.Usuario;
import com.seeds.neuroapp.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario salvarUsuario(Usuario usuario) throws Exception {
        if (usuarioRepository.findByEmail(usuario.getEmail())!= null){
            throw new Exception("usaldkjf");// Mudar para exception personalizada http status code 400
        }

        return usuarioRepository.save(usuario);
    }
}
