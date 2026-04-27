package com.unibra.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PacienteAtualizacaoDTO {

    private String nome;
    private String telefone;
    private EnderecoAtualizacaoDTO endereco;

}
