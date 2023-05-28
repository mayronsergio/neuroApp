package com.seeds.neuroapp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAvaliacao;

    private Date dataHora;

    @OneToMany
    private List<Usuario> usuario;

    @OneToMany
    private List<Paciente> paciente;
}
