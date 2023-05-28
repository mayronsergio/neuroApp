package com.seeds.neuroapp.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Leito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLeito;

    @OneToOne
    private Paciente paciente;

    private int status;
}
