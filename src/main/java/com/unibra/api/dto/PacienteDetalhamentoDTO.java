package com.unibra.api.dto;

import com.unibra.api.entidades.Paciente;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PacienteDetalhamentoDTO {
    
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    
    private EnderecoDetalhamentoDTO enderecoDetalhamentoDTO;

    public PacienteDetalhamentoDTO(Paciente paciente){
        this.id = paciente.getId();
        this.nome = paciente.getNome();
        this.cpf = paciente.getCpf();
        this.email = paciente.getEmail();
        this.telefone = paciente.getTelefone();

        this.enderecoDetalhamentoDTO = new EnderecoDetalhamentoDTO(paciente.getEndereco());
    }

}
