package com.seeds.neuroapp.controller;

import com.seeds.neuroapp.model.Paciente;
import com.seeds.neuroapp.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteCotroller {

    private final PacienteService pacienteService;

    @Autowired
    public PacienteCotroller(PacienteService pacienteService){
        this.pacienteService = pacienteService;
    }

    @PostMapping
    public Paciente salvarPaciente(@RequestBody Paciente paciente){
        return pacienteService.salvarPaciente(paciente);
    }

    @GetMapping("/{id}")
    public Paciente consultarPorId(@PathVariable Long id){
        return pacienteService.consultarPacientePorId(id);
    }

    @GetMapping
    public List<Paciente> consultarTodosPacientes(){
        return pacienteService.consultarTodosPacientes();
    }

    @PutMapping("/{id}")
    public Paciente atualizarPaciente(@RequestBody Paciente paciente, @PathVariable Long id){
        return pacienteService.atualizarPaciente(paciente, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarPaciente(@PathVariable Long id){
        pacienteService.deletarPaciente(id);
    }
}
