package com.seeds.neuroapp.controller;

import com.seeds.neuroapp.model.Leito;
import com.seeds.neuroapp.service.LeitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leitos")
public class LeitoController {

    private final LeitoService leitoService;

    @Autowired
    public LeitoController(LeitoService leitoService){
        this.leitoService = leitoService;
    }

    @PostMapping
    public Leito salvarLeito(@RequestBody Leito leito){
        return leitoService.salvarLeito(leito);
    }

    @GetMapping("/{id}")
    public Leito consultarPorId(@PathVariable Long id){
        return leitoService.consultarLeitoPorId(id);
    }

    @GetMapping
    public List<Leito> consultarTodosPacientes(){
        return leitoService.consultarTodosLeitos();
    }

    @PutMapping("/{id}")
    public Leito atualizarPaciente(@RequestBody Leito leito, @PathVariable Long id){
        return leitoService.atualizarLeito(leito, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarPaciente(@PathVariable Long id){
        leitoService.deletarLeito(id);
    }
}
