package com.unibra.api.excecao;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.unibra.api.dto.ErroEntradaInvalidaDTO;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class TratamentoErro {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> tratarErroIdInexistente(){
        return ResponseEntity.notFound().build();
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> tratarErroEntradaInvalida(MethodArgumentNotValidException e){
        var erros = e.getFieldErrors();
    
    
        return ResponseEntity.badRequest().body(erros.stream()
            .map(ErroEntradaInvalidaDTO::new)
            .toList());

    }
    
}
