package com.unibra.api.controladores;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.unibra.api.dto.MedicoAtualizacaoDTO;
import com.unibra.api.dto.MedicoCadastroDTO;
import com.unibra.api.dto.MedicoDetalhamentoDTO;
import com.unibra.api.dto.MedicoRespostaDTO;
import com.unibra.api.entidades.Medico;
import com.unibra.api.repositorios.MedicoRepositorio;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/medico")
public class MedicoControlador {

    @Autowired
    private MedicoRepositorio medicoRepositorio;

    @Transactional
    @PostMapping("cadastrar")
    public ResponseEntity<MedicoDetalhamentoDTO> cadastrarMedico(@RequestBody @Valid MedicoCadastroDTO medicoDTO, UriComponentsBuilder uriBuilder){
        Medico medico = new Medico(medicoDTO);
        medicoRepositorio.save(medico);

        MedicoDetalhamentoDTO medicoDetalhamentoDTO = new MedicoDetalhamentoDTO(medico);

        var uri = uriBuilder.path("/medico/{id}").buildAndExpand(medicoDetalhamentoDTO.getId()).toUri();

        return ResponseEntity.created(uri).body(medicoDetalhamentoDTO);
    }

    @GetMapping("listar")
    public ResponseEntity<Page<MedicoRespostaDTO>> listarMedicos(@PageableDefault(size = 5, sort = {"nome"}) Pageable paginacao) {
        var page = medicoRepositorio.findAllByAtivoTrue(paginacao).map(MedicoRespostaDTO::new);
        
        return ResponseEntity.ok(page);
    }
    
    @Transactional
    @PutMapping("atualizar/{id}")
    public ResponseEntity<MedicoDetalhamentoDTO> atualizarMedico(@PathVariable Long id, @RequestBody MedicoAtualizacaoDTO medicoAtualizacaoDTO) {
        var medico = medicoRepositorio.getReferenceById(id);
        medico.atualizar(medicoAtualizacaoDTO);
        
        MedicoDetalhamentoDTO detalhamentoDTO = new MedicoDetalhamentoDTO(medico);

        return ResponseEntity.ok(detalhamentoDTO);
    }

    @Transactional
    @DeleteMapping("deletar/{id}")
    public ResponseEntity<?> deletarMedico(@PathVariable Long id) {
        var medico = medicoRepositorio.getReferenceById(id);
        medico.inativar();

        return ResponseEntity.noContent().build();
    }


    @GetMapping("/{id}")
    public ResponseEntity<MedicoDetalhamentoDTO> detalhar(@PathVariable Long id) {
        var medico = medicoRepositorio.getReferenceById(id);

        MedicoDetalhamentoDTO detalhamentoDTO = new MedicoDetalhamentoDTO(medico);

        return ResponseEntity.ok(detalhamentoDTO);
    }
    

}
