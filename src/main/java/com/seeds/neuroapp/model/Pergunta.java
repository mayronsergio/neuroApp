package com.seeds.neuroapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Pergunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPergunta;

    @Size(max = 150, message = "O campo 'descricaoPergunta' deve ter no máximo 150 caracteres.")
    private String descricaoPergunta;

    @ManyToOne
    @JoinColumn(name = "grupo_id")
    private Grupo grupo;
}
