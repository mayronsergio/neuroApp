package com.seeds.neuroapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class OpcoesPerguntas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOpcoesPerguntas;

    @Size(max = 150, message = "O campo 'descricaoOpcoes' deve ter no máximo 150 caracteres.")
    private String descricaoOpcoes;

    private int valor;

    @NotNull(message = "O campo 'pergunta' não pode ser nulo.")
    @ManyToOne
    @JoinColumn(name = "pergunta_id")
    private Perguntas pergunta;
}
