package com.unibra.api.controladores;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping(value = "/teste")
public class Controlador {

    @GetMapping("path")
    public String getMethodName() {
        return "Olá, mundo!";
    }
    

}
