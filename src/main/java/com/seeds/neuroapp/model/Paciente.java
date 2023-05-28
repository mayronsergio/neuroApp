package com.seeds.neuroapp.model;

import com.seeds.neuroapp.model.enums.Sexo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.Date;
@Entity
@Data
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPaciente;

    @Size(max = 80, message = "O campo 'nomePaciente' deve ter no máximo 80 caracteres.")
    private String nomePaciente;

    private Date dataNascimento;

    private Sexo sexo;
}
