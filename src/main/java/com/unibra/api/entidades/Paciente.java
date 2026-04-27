package com.unibra.api.entidades;

import com.unibra.api.dto.PacienteAtualizacaoDTO;
import com.unibra.api.dto.PacienteCadastroDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String telefone;
    private String cpf;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco", referencedColumnName = "id")
    private Endereco endereco;

    private boolean ativo;

    public Paciente(PacienteCadastroDTO pacienteCadastroDTO){
        this.nome = pacienteCadastroDTO.getNome();
        this.email = pacienteCadastroDTO.getEmail();
        this.telefone = pacienteCadastroDTO.getTelefone();
        this.cpf = pacienteCadastroDTO.getCpf();

        this.endereco = new Endereco(pacienteCadastroDTO.getEndereco());

        this.ativo = true;
    }


    public void atualizar(PacienteAtualizacaoDTO pacienteAtualizacaoDTO){
        if(pacienteAtualizacaoDTO.getNome() != null){
            this.nome = pacienteAtualizacaoDTO.getNome();
        }

        if(pacienteAtualizacaoDTO.getTelefone() != null){
            this.telefone = pacienteAtualizacaoDTO.getTelefone();
        }

        if(pacienteAtualizacaoDTO.getEndereco() != null){
            this.endereco.atualizar(pacienteAtualizacaoDTO.getEndereco());
        }
    }


    public void inativar(){
        this.ativo = false;
    }
}
