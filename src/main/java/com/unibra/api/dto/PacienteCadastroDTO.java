package com.unibra.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PacienteCadastroDTO {

    @NotBlank
    private String nome;
    @NotBlank @Email
    private String email;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cpf;

    @Valid
    private EnderecoCadastroDTO endereco;

}
