package com.unibra.api.repositorios;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.unibra.api.entidades.Paciente;

public interface PacienteRepositorio extends JpaRepository<Paciente, Long>{

    public Page<Paciente> findAllByAtivoTrue(Pageable paginacao);

}
