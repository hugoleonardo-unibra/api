package com.unibra.api.entidades;

import com.unibra.api.dto.MedicoAtualizacaoDTO;
import com.unibra.api.dto.MedicoCadastroDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name="medico")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String telefone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco", referencedColumnName = "id")
    private Endereco endereco;

    private boolean ativo;

    public Medico(MedicoCadastroDTO medicoDTO){
        this.nome = medicoDTO.getNome();
        this.email = medicoDTO.getEmail();
        this.telefone = medicoDTO.getTelefone();
        this.crm = medicoDTO.getCrm();

        this.especialidade = medicoDTO.getEspecialidade();

        this.endereco = new Endereco(medicoDTO.getEndereco());

        this.ativo = true;
    }

    public void atualizar(MedicoAtualizacaoDTO medicoAtualizacaoDTO){
        if (medicoAtualizacaoDTO.getNome() !=  null) {   
            this.nome = medicoAtualizacaoDTO.getNome();
        }
        if (medicoAtualizacaoDTO.getTelefone() !=  null){
            this.telefone = medicoAtualizacaoDTO.getTelefone();
        }
        if(medicoAtualizacaoDTO.getEnderecoAtualizacaoDTO() != null){
            this.endereco.atualizar(medicoAtualizacaoDTO.getEnderecoAtualizacaoDTO());
        }
    }

    public void inativar(){
        this.ativo = false;
    }
}
