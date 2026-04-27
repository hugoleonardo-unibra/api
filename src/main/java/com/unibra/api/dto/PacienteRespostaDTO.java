package com.unibra.api.dto;
import com.unibra.api.entidades.Paciente;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PacienteRespostaDTO {

    private Long id;
    private String nome;
    private String email;
    private String cpf;

    public PacienteRespostaDTO(Paciente paciente){
        this.id = paciente.getId();
        this.nome = paciente.getNome();
        this.email = paciente.getEmail();
        this.cpf = paciente.getCpf();
    }

}
