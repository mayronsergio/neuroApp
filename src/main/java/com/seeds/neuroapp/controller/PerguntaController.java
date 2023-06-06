package com.seeds.neuroapp.controller;

import com.seeds.neuroapp.model.Pergunta;
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
    public Pergunta salvarPergunta(@Valid @RequestBody Pergunta pergunta){
        return perguntasService.salvarPerguntas(pergunta);
    }

    @GetMapping("/{id}")
    public Pergunta consultarPorId(@PathVariable Long id){
        return perguntasService.consultarPerguntasPorId(id);
    }

    @GetMapping
    public List<Pergunta> consultarTodosPacientes(){
        return perguntasService.consultarTodosPerguntas();
    }

    @PutMapping("/{id}")
    public Pergunta atualizarPaciente(@Valid @RequestBody Pergunta pergunta, @PathVariable Long id){
        return perguntasService.atualizarPerguntas(pergunta, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarPaciente(@PathVariable Long id){
        perguntasService.deletarPerguntas(id);
    }
}
