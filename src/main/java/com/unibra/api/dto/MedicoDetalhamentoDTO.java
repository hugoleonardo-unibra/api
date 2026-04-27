package com.unibra.api.dto;

import com.unibra.api.entidades.Especialidade;
import com.unibra.api.entidades.Medico;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedicoDetalhamentoDTO {

    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;

    private Especialidade especialidade;
    
    private EnderecoDetalhamentoDTO endereco;

    public MedicoDetalhamentoDTO(Medico medico){
        this.id = medico.getId();
        this.nome = medico.getNome();
        this.crm = medico.getCrm();
        this.email = medico.getEmail();
        this.telefone = medico.getTelefone();

        this.especialidade = medico.getEspecialidade();

        this.endereco = new EnderecoDetalhamentoDTO(medico.getEndereco());
    }
}
