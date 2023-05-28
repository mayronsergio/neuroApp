package com.seeds.neuroapp.service;

import com.seeds.neuroapp.exception.ConflictException;
import com.seeds.neuroapp.exception.ResourceNotFoundException;
import com.seeds.neuroapp.model.Leito;
import com.seeds.neuroapp.repository.LeitoRepository;
import com.seeds.neuroapp.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeitoService {
    private final LeitoRepository leitoRepository;
    private final PacienteRepository pacienteRepository;

    @Autowired
    public LeitoService(LeitoRepository leitoRepository, PacienteRepository pacienteRepository){
        this.leitoRepository = leitoRepository;
        this.pacienteRepository = pacienteRepository;
    }


    public Leito salvarLeito(Leito leito){
        if (leito.getPaciente() != null){
            verificarPacienteExistente(leito);
            verificarAssociacaoPacienteLeitoDuplicada(leito);
        }
        return leitoRepository.save(leito);
    }


    public Leito consultarLeitoPorId(Long id){
        return leitoRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Leito não encontrado"));
    }

    public List<Leito> consultarTodosLeitos(){
        return leitoRepository.findAll();
    }

    public Leito atualizarLeito(Leito leito, Long id){
        if (!leitoRepository.existsById(id)){
            throw new ResourceNotFoundException("Leito não encontrado");
        }
        if (leito.getPaciente() != null){
            verificarPacienteExistente(leito);
            verificarAssociacaoPacienteLeitoDuplicada(leito);
        }
        return leitoRepository.save(leito);
    }

    public void deletarLeito(Long id){
        if(!leitoRepository.existsById(id)){
            throw new ResourceNotFoundException("Leito não encontrado");
        }
        leitoRepository.deleteById(id);
    }

    public void verificarPacienteExistente(Leito leito){
        if (!pacienteRepository.existsById(leito.getPaciente().getIdPaciente())){
            throw new ResourceNotFoundException("Paciente não encontrado");
        }
    }

    public void verificarAssociacaoPacienteLeitoDuplicada(Leito leito){
        if (leitoRepository.existsByPaciente(leito.getPaciente())){
            throw new ConflictException("O paciente já está associado a um leito.");
        }
    }
}