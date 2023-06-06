package com.seeds.neuroapp.service;

import com.seeds.neuroapp.exception.BadRequestException;
import com.seeds.neuroapp.exception.ResourceNotFoundException;
import com.seeds.neuroapp.model.OpcoesPerguntas;
import com.seeds.neuroapp.model.Pergunta;
import com.seeds.neuroapp.repository.OpcoesPerguntasRepository;
import com.seeds.neuroapp.repository.PerguntasRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpcoesPerguntasService {

    private final OpcoesPerguntasRepository opcoesPerguntasRepository;
    private final PerguntasRepository perguntasRepository;

    @Autowired
    public OpcoesPerguntasService(OpcoesPerguntasRepository opcoesPerguntasRepository, PerguntasRepository perguntasRepository){
        this.opcoesPerguntasRepository = opcoesPerguntasRepository;
        this.perguntasRepository = perguntasRepository;
    }

    public OpcoesPerguntas salvarOpcoesPerguntas(OpcoesPerguntas opcoesPerguntas){
        if (opcoesPerguntas.getPergunta()!=null){
            verificarExistenciaPergunta(opcoesPerguntas.getPergunta());
            return opcoesPerguntasRepository.save(opcoesPerguntas);
        }
        throw new BadRequestException("A pergunta associada não pode ser nula.");
    }

    public OpcoesPerguntas consultarOpcoesPerguntasPorId(Long id){
        return opcoesPerguntasRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("OpcaoPergunta não encontrada"));
    }

    public List<OpcoesPerguntas> consultarTodosOpcoesPerguntas(){
        return opcoesPerguntasRepository.findAll();
    }

    public OpcoesPerguntas atualizarOpcoesPerguntas(OpcoesPerguntas opcoesPerguntas, Long id){
        if (opcoesPerguntas.getPergunta()==null){
            throw new BadRequestException("A pergunta associada não pode ser nula.");
        }
        OpcoesPerguntas opcoesPerguntasExistente = opcoesPerguntasRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("OpcaoPergunta não encontrada"));
        verificarExistenciaPergunta(opcoesPerguntas.getPergunta());
        BeanUtils.copyProperties(opcoesPerguntas, opcoesPerguntasExistente, "idOpcoesPerguntas");
        return opcoesPerguntasRepository.save(opcoesPerguntasExistente);
    }

    public void deletarOpcoesPerguntas(Long id){
        opcoesPerguntasRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("OpcaoPergunta não encontrada"));
        opcoesPerguntasRepository.deleteById(id);
    }

    public void verificarExistenciaPergunta(Pergunta pergunta){
        perguntasRepository.findById(pergunta.getIdPergunta()).orElseThrow(()-> new ResourceNotFoundException("Pergunta não encontrada"));
    }
}
