package com.seeds.neuroapp.controller;

import com.seeds.neuroapp.model.Paciente;
import com.seeds.neuroapp.model.Perguntas;
import com.seeds.neuroapp.service.PerguntasService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/perguntas")
public class PerguntaController {

    private final PerguntasService perguntasService;

    @Autowired
    public PerguntaController(PerguntasService perguntasService){
        this.perguntasService = perguntasService;
    }

    @PostMapping
    public Perguntas salvarPergunta(@Valid @RequestBody Perguntas perguntas){
        return perguntasService.salvarPerguntas(perguntas);
    }

    @GetMapping("/{id}")
    public Perguntas consultarPorId(@PathVariable Long id){
        return perguntasService.consultarPerguntasPorId(id);
    }

    @GetMapping
    public List<Perguntas> consultarTodosPacientes(){
        return perguntasService.consultarTodosPerguntas();
    }

    @PutMapping("/{id}")
    public Perguntas atualizarPaciente(@Valid @RequestBody Perguntas perguntas, @PathVariable Long id){
        return perguntasService.atualizarPerguntas(perguntas, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarPaciente(@PathVariable Long id){
        perguntasService.deletarPerguntas(id);
    }
}
