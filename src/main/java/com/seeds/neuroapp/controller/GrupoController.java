package com.seeds.neuroapp.controller;

import com.seeds.neuroapp.model.Grupo;
import com.seeds.neuroapp.service.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grupos")
public class GrupoController {

    private GrupoService grupoService;

    @Autowired
    public GrupoController(GrupoService grupoService){
        this.grupoService = grupoService;
    }

    @PostMapping
    public Grupo salvar(@RequestBody Grupo grupo){
        return grupoService.salvar(grupo);
    }

    @GetMapping
    public List<Grupo> consultarTodos(){
        return grupoService.consultarTodos();
    }

    @GetMapping("/{id}")
    public Grupo consultarPorId(@PathVariable Long id){
        return grupoService.consultarPorId(id);
    }

    @PutMapping("/{id}")
    public Grupo atualizar(@PathVariable Long id, @RequestBody Grupo grupo){
        return grupoService.atualizar(id, grupo);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id){
        grupoService.deletar(id);
    }

}
