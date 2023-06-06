package com.seeds.neuroapp.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Columns;

import java.util.Date;
import java.util.List;

@Entity
@Data
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAvaliacao;

    private Date dataHora;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @ManyToMany
    @JoinTable(
            name = "avaliacao_opcoes",
            joinColumns = @JoinColumn(name = "avaliacao_id"),
            inverseJoinColumns =  @JoinColumn(name = "opcoes_perguntas_id")
    )
    private List<OpcoesPerguntas> opcoesPerguntas;
}
