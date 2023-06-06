package com.seeds.neuroapp.service;

import com.seeds.neuroapp.exception.ResourceNotFoundException;
import com.seeds.neuroapp.model.Grupo;
import com.seeds.neuroapp.repository.GrupoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrupoService {

    private GrupoRepository grupoRepository;

    @Autowired
    public GrupoService(GrupoRepository grupoRepository){
        this.grupoRepository = grupoRepository;
    }

    public Grupo salvar(Grupo grupo){
        return grupoRepository.save(grupo);
    }

    public List<Grupo> consultarTodos(){
        return grupoRepository.findAll();
    }

    public Grupo consultarPorId(Long id){
        return grupoRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Grupo nao encontrado."));
    }

    public Grupo atualizar(Long id, Grupo grupo){
        Grupo grupoExistente = grupoRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Grupo nao encontrado."));
        BeanUtils.copyProperties(grupo, grupoExistente, "idGrupo");
        return grupoRepository.save(grupoExistente);
    }

    public void deletar(Long id){
        grupoRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Grupo nao encontrado."));
        grupoRepository.deleteById(id);
    }
}
