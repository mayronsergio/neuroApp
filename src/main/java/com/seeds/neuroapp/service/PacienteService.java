package com.seeds.neuroapp.service;

import com.seeds.neuroapp.exception.ResourceNotFoundException;
import com.seeds.neuroapp.model.Paciente;
import com.seeds.neuroapp.model.Usuario;
import com.seeds.neuroapp.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    @Autowired
    public PacienteService(PacienteRepository pacienteRepository){
        this.pacienteRepository = pacienteRepository;
    }

    public Paciente salvarPaciente(Paciente paciente){
        return pacienteRepository.save(paciente);
    }

    public Paciente consultarPorId(Long id){
        return pacienteRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Paciente não encontrado"));
    }

    public List<Paciente> consultarTodosUsuarios(){
        return pacienteRepository.findAll();
    }

    public Paciente atualizarUsuario(Paciente paciente, Long id){
        if (!pacienteRepository.existsById(id)){
            throw new ResourceNotFoundException("Paciente não encontrado");
        }
        return pacienteRepository.save(paciente);
    }

    public void deletarUsuario(Long id){
        if(!pacienteRepository.existsById(id)){
            throw new ResourceNotFoundException("Paciente não encontrado");
        }
        pacienteRepository.deleteById(id);
    }
}
