package com.unibra.api.dto;

import com.unibra.api.entidades.Especialidade;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedicoCadastroDTO {

    @NotBlank
    private String nome;
    @NotBlank @Email
    private String email;
    @NotBlank
    private String telefone;
    @NotBlank
    private String crm;

    private Especialidade especialidade;
    
    @Valid
    private EnderecoCadastroDTO endereco;
}
