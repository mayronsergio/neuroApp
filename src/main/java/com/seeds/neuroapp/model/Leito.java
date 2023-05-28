package com.seeds.neuroapp.model;

import com.seeds.neuroapp.model.enums.StatusLeito;
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

    @Enumerated(EnumType.STRING)
    private StatusLeito status;
}
