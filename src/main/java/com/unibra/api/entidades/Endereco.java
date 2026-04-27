package com.unibra.api.entidades;

import com.unibra.api.dto.EnderecoAtualizacaoDTO;
import com.unibra.api.dto.EnderecoCadastroDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="endereco")
public class Endereco {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String rua;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;

    public Endereco(EnderecoCadastroDTO enderecoDTO) {
        this.rua = enderecoDTO.getRua();
        this.numero = enderecoDTO.getNumero();
        this.complemento = enderecoDTO.getComplemento();
        this.bairro = enderecoDTO.getBairro();
        this.cidade = enderecoDTO.getCidade();
        this.estado = enderecoDTO.getEstado();
        this.cep = enderecoDTO.getCep();
    }

    public void atualizar(EnderecoAtualizacaoDTO enderecoDTO){
        if (enderecoDTO.getRua() != null){
            this.rua = enderecoDTO.getRua();
        }
        if(enderecoDTO.getNumero() != null){
            this.numero = enderecoDTO.getNumero();
        }
        if(enderecoDTO.getComplemento() != null){
            this.complemento = enderecoDTO.getComplemento();
        }
        if(enderecoDTO.getBairro() != null){
            this.bairro = enderecoDTO.getBairro();
        }
        if(enderecoDTO.getCidade() != null){
            this.cidade = enderecoDTO.getCidade();
        }
        if(enderecoDTO.getEstado() != null){
            this.estado = enderecoDTO.getEstado();
        }
        if(enderecoDTO.getCep() != null){
            this.cep = enderecoDTO.getCep();
        }
    }
}
