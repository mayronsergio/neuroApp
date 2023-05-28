package com.seeds.neuroapp.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.seeds.neuroapp.model.enums.TipoUsuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @NotNull(message = "O campo 'nomeUsuario' não pode ser nulo.")
    @NotBlank(message = "O campo 'nomeUsuario' não pode estar vazio.")
    @Size(max = 80, message = "O campo 'nomeUsuario' deve ter no máximo 150 caracteres.")
    private String nomeUsuario;

    @NotNull(message = "O campo 'email' não pode ser nulo.")
    @NotBlank(message = "O campo 'email' não pode estar vazio.")
    @Email(message = "O campo 'email' deve ser preenchido com um endereço de e-mail válido.")
    @Size(max = 80, message = "O campo 'email' deve ter no máximo 150 caracteres.")
    private String email;

    @NotNull(message = "O campo 'senha' não pode ser nulo.")
    private String senhaUsuario;

    @NotNull(message = "O campo 'tipoUsuario' não pode ser nulo.")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;

}
