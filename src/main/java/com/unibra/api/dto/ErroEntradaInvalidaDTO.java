package com.unibra.api.dto;

import org.springframework.validation.FieldError;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ErroEntradaInvalidaDTO {

    private String campo;
    private String mensagem;
    

    public ErroEntradaInvalidaDTO(FieldError erro){
        this.campo = erro.getField();
        this.mensagem = erro.getDefaultMessage();
    }

}
