package com.seeds.neuroapp.controller;

import com.seeds.neuroapp.model.Avaliacao;
import com.seeds.neuroapp.service.AvaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/avaliacoes")
public class AvaliacaoController {

    private AvaliacaoService avaliacaoService;

    @Autowired
    public AvaliacaoController(AvaliacaoService avaliacaoService){
        this.avaliacaoService = avaliacaoService;
    }

    @PostMapping
    public Avaliacao salvar(@RequestBody Avaliacao avaliacao){
        return avaliacaoService.salvar(avaliacao);
    }

    @GetMapping
    public List<Avaliacao> consultarTodos(){
        return avaliacaoService.consultarTodas();
    }

    @GetMapping("/{id}")
    public Avaliacao consultarPorId(@PathVariable Long id){
        return avaliacaoService.consultarPorId(id);
    }

    @PutMapping("/{id}")
    public Avaliacao atualizar(@PathVariable Long id, @RequestBody Avaliacao avaliacao){
        return avaliacaoService.atualizar(id, avaliacao);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id){
        avaliacaoService.deletar(id);
    }
}
