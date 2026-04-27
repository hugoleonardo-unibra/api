package com.unibra.api.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.unibra.api.dto.PacienteAtualizacaoDTO;
import com.unibra.api.dto.PacienteCadastroDTO;
import com.unibra.api.dto.PacienteDetalhamentoDTO;
import com.unibra.api.dto.PacienteRespostaDTO;
import com.unibra.api.entidades.Paciente;
import com.unibra.api.repositorios.PacienteRepositorio;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/paciente")
public class PacienteControlador {

    @Autowired
    private PacienteRepositorio pacienteRepositorio;

    @Transactional
    @PostMapping("/cadastrar")
    public ResponseEntity<PacienteDetalhamentoDTO> cadastrarPaciente(@RequestBody @Valid PacienteCadastroDTO pacienteCadastroDTO, UriComponentsBuilder uriBuilder){
        Paciente paciente = new Paciente(pacienteCadastroDTO);
        this.pacienteRepositorio.save(paciente);
        
        var pacienteDetalhamentoDTO = new PacienteDetalhamentoDTO(paciente);
        var uri = uriBuilder.path("/paciente/{id}").buildAndExpand(pacienteDetalhamentoDTO.getId()).toUri();

        return ResponseEntity.created(uri).body(pacienteDetalhamentoDTO);
    }

    @Transactional
    @PutMapping("atualizar/{id}")
    public ResponseEntity<PacienteDetalhamentoDTO> atualizarPaciente(@PathVariable Long id, @RequestBody PacienteAtualizacaoDTO pacienteAtualizacaoDTO) {
        var paciente = pacienteRepositorio.getReferenceById(id);
        paciente.atualizar(pacienteAtualizacaoDTO);
        
        PacienteDetalhamentoDTO pacienteDetalhamentoDTO = new PacienteDetalhamentoDTO(paciente);

        return ResponseEntity.ok(pacienteDetalhamentoDTO);
    }

    @GetMapping("/listar")
    public ResponseEntity<Page<PacienteRespostaDTO>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        var page = pacienteRepositorio.findAllByAtivoTrue(paginacao).map(PacienteRespostaDTO::new);

        return ResponseEntity.ok(page);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<PacienteDetalhamentoDTO> detalhar(@PathVariable Long id) {
        var paciente = pacienteRepositorio.getReferenceById(id);

        PacienteDetalhamentoDTO pacienteDetalhamentoDTO = new PacienteDetalhamentoDTO(paciente);

        return ResponseEntity.ok(pacienteDetalhamentoDTO);
    }
    
    @Transactional
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id){
        var paciente = pacienteRepositorio.getReferenceById(id);

        paciente.inativar();

        return ResponseEntity.noContent().build();
    }

}
