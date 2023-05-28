package com.seeds.neuroapp.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Entity
@Data
public class OpcoesPerguntas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOpcoesPerguntas;

    @Length(max = 150)
    private String descricaoOpcoes;

    private int valor;

    @ManyToOne
    private Perguntas perguntas;
}
