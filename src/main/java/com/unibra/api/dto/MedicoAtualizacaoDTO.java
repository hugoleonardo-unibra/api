package com.unibra.api.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MedicoAtualizacaoDTO {

    private String nome;
    private String telefone;
    private EnderecoAtualizacaoDTO enderecoAtualizacaoDTO;
}
