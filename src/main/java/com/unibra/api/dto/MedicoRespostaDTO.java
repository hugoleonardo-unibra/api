package com.unibra.api.dto;

import com.unibra.api.entidades.Medico;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedicoRespostaDTO {

    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;


    public MedicoRespostaDTO(Medico medico){
        this.id = medico.getId();
        this.nome = medico.getNome();
        this.email = medico.getEmail();
        this.telefone = medico.getTelefone();
        this.crm = medico.getCrm();
    }
}
