package com.seeds.neuroapp.service;

import com.seeds.neuroapp.exception.ResourceNotFoundException;
import com.seeds.neuroapp.model.Perguntas;
import com.seeds.neuroapp.repository.PerguntasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerguntasService {

    private final PerguntasRepository perguntasRepository;

    @Autowired
    public PerguntasService(PerguntasRepository perguntasRepository){
        this.perguntasRepository = perguntasRepository;
    }

    public Perguntas salvarPerguntas(Perguntas perguntas){
        return perguntasRepository.save(perguntas);
    }

    public Perguntas consultarPerguntasPorId(Long id){
        return perguntasRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Pergunta não encontrada"));
    }

    public List<Perguntas> consultarTodosPerguntas(){
        return perguntasRepository.findAll();
    }

    public Perguntas atualizarPerguntas(Perguntas perguntas, Long id){
        if (!perguntasRepository.existsById(id)){
            throw new ResourceNotFoundException("Pergunta não encontrada");
        }
        return perguntasRepository.save(perguntas);
    }

    public void deletarPerguntas(Long id){
        if(!perguntasRepository.existsById(id)){
            throw new ResourceNotFoundException("Pergunta não encontrada");
        }
        perguntasRepository.deleteById(id);
    }
}
