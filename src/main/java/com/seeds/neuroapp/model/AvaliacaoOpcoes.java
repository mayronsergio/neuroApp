package com.seeds.neuroapp.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class AvaliacaoOpcoes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAvaliacaoOpcoes;

    @ManyToOne
    private OpcoesPerguntas opcoesPerguntas;

    @ManyToOne
    private Avaliacao avaliacao;
}
