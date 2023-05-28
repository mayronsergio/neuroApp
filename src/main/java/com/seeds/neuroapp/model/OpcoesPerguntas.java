package com.seeds.neuroapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Entity
@Data
public class OpcoesPerguntas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOpcoesPerguntas;

    @Size(max = 150, message = "O campo 'descricaoOpcoes' deve ter no máximo 150 caracteres.")
    private String descricaoOpcoes;

    private int valor;

    @ManyToOne
    private Perguntas perguntas;
}
