package com.seeds.neuroapp.service;

import com.seeds.neuroapp.exception.BadRequestException;
import com.seeds.neuroapp.exception.ResourceNotFoundException;
import com.seeds.neuroapp.model.Usuario;
import com.seeds.neuroapp.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario salvarUsuario(Usuario usuario) throws Exception {
        if (usuarioRepository.findByEmail(usuario.getEmail())!= null){
            throw new BadRequestException("Usuário já existente");
        }
        return usuarioRepository.save(usuario);
    }

    public Usuario consultarUsuarioPorId(Long id){
        return usuarioRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Usuário não encontrado"));
    }

    public List<Usuario> consultarTodosUsuarios(){
        return usuarioRepository.findAll();
    }

    public Usuario atualizarUsuario(Usuario usuario, Long id){
        usuarioRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Usuário não encontrado"));
        return usuarioRepository.save(usuario);
    }

    public void deletarUsuario(Long id){
        usuarioRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Usuário não encontrado"));
        usuarioRepository.deleteById(id);
    }
}
