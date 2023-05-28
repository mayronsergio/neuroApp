package com.seeds.neuroapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Entity
@Data
public class Perguntas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPerguntas;

    @Length(max = 150)
    private String descricaoPerguntas;
}
