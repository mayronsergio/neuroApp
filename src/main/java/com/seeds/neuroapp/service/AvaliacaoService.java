package com.seeds.neuroapp.service;

import com.seeds.neuroapp.exception.ResourceNotFoundException;
import com.seeds.neuroapp.model.Avaliacao;
import com.seeds.neuroapp.repository.AvaliacaoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoService {

    private AvaliacaoRepository avaliacaoRepository;

    @Autowired
    public AvaliacaoService(AvaliacaoRepository avaliacaoRepository){
        this.avaliacaoRepository = avaliacaoRepository;
    }

    public Avaliacao salvar(Avaliacao avaliacao){
        return avaliacaoRepository.save(avaliacao);
    }


    public Avaliacao consultarPorId(Long id){
        return avaliacaoRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Avaliação não encontrada"));
    }

    public List<Avaliacao> consultarTodas(){
        return avaliacaoRepository.findAll();
    }

    public Avaliacao atualizar(Long id, Avaliacao avaliacao){
        Avaliacao avaliacaoExistente = avaliacaoRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Avaliação não encontrada"));
        BeanUtils.copyProperties(avaliacao, avaliacaoExistente, "idAvaliacao");
        return avaliacaoRepository.save(avaliacaoExistente);
    }

    public void deletar(Long id){
        avaliacaoRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Avaliação não encontrada"));
        avaliacaoRepository.deleteById(id);
    }
}
