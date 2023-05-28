package com.seeds.neuroapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Entity
@Data
public class Perguntas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPerguntas;

    @Size(max = 150, message = "O campo 'descricaoPerguntas' deve ter no máximo 150 caracteres.")
    private String descricaoPerguntas;
}
