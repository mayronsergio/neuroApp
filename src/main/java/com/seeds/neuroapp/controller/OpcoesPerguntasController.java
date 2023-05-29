package com.seeds.neuroapp.controller;

import com.seeds.neuroapp.model.OpcoesPerguntas;
import com.seeds.neuroapp.model.Paciente;
import com.seeds.neuroapp.service.OpcoesPerguntasService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/opcoesPerguntas")
public class OpcoesPerguntasController {

    private final OpcoesPerguntasService opcoesPerguntasService;

    @Autowired
    public OpcoesPerguntasController(OpcoesPerguntasService opcoesPerguntasService){
        this.opcoesPerguntasService = opcoesPerguntasService;
    }

    @PostMapping
    public OpcoesPerguntas salvarOpcoesPerguntas(@Valid @RequestBody OpcoesPerguntas opcoesPerguntas){
        return opcoesPerguntasService.salvarOpcoesPerguntas(opcoesPerguntas);
    }

    @GetMapping("/{id}")
    public OpcoesPerguntas consultarPorId(@PathVariable Long id){
        return opcoesPerguntasService.consultarOpcoesPerguntasPorId(id);
    }

    @GetMapping
    public List<OpcoesPerguntas> consultarTodosOpcoesPerguntas(){
        return opcoesPerguntasService.consultarTodosOpcoesPerguntas();
    }

    @PutMapping("/{id}")
    public OpcoesPerguntas atualizarOpcoesPerguntas(@Valid @RequestBody OpcoesPerguntas opcoesPerguntas, @PathVariable Long id){
        return opcoesPerguntasService.atualizarOpcoesPerguntas(opcoesPerguntas, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarOpcoesPerguntas(@PathVariable Long id){
        opcoesPerguntasService.deletarOpcoesPerguntas(id);
    }
}
