package com.unibra.api.dto;

import com.unibra.api.entidades.Endereco;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoDetalhamentoDTO {

    private String rua;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;

    public EnderecoDetalhamentoDTO(Endereco endereco) {
        this.rua = endereco.getRua();
        this.numero = endereco.getNumero();
        this.complemento = endereco.getComplemento();
        this.bairro = endereco.getBairro();
        this.cidade = endereco.getCidade();
        this.estado = endereco.getEstado();
        this.cep = endereco.getCep();
    }
}
