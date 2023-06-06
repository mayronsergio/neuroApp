package com.seeds.neuroapp.service;

import com.seeds.neuroapp.exception.ResourceNotFoundException;
import com.seeds.neuroapp.model.Pergunta;
import com.seeds.neuroapp.repository.PerguntasRepository;
import org.springframework.beans.BeanUtils;
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

    public Pergunta salvarPerguntas(Pergunta pergunta){
        return perguntasRepository.save(pergunta);
    }

    public Pergunta consultarPerguntasPorId(Long id){
        return perguntasRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Pergunta não encontrada"));
    }

    public List<Pergunta> consultarTodosPerguntas(){
        return perguntasRepository.findAll();
    }

    public Pergunta atualizarPerguntas(Pergunta pergunta, Long id){
        Pergunta perguntaExistente = perguntasRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Pergunta não encontrada"));
        BeanUtils.copyProperties(pergunta, perguntaExistente, "idPergunta");
        return perguntasRepository.save(perguntaExistente);
    }

    public void deletarPerguntas(Long id){
        perguntasRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Pergunta não encontrada"));
        perguntasRepository.deleteById(id);
    }
}
