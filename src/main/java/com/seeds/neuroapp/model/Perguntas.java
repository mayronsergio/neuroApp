package com.seeds.neuroapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Entity
@Data
public class Perguntas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPerguntas;

    @Size(max = 150, message = "O campo 'descricaoPerguntas' deve ter no máximo 150 caracteres.")
    private String descricaoPerguntas;
}
