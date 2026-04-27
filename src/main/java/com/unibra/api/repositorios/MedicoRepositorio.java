package com.unibra.api.repositorios;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.unibra.api.entidades.Medico;

public interface MedicoRepositorio extends JpaRepository<Medico, Long> {

    public Page<Medico> findAllByAtivoTrue(Pageable paginacao);

}
