package com.api.repository;

import java.util.List;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.api.entity.Lancamento;

@Transactional(readOnly = true)
@NamedQueries({
		@NamedQuery(name = "LancamentoRepository.findByFuncionarioId", query = "select lancamento from Lancamento lancamento where lancamento.funcionario.id = :funcionarioId") })
public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {

	List<Lancamento> findByFuncionarioId(@Param("funcionarioId") Long funcionarioId);

	List<Lancamento> findByFuncionarioId(@Param("funcionarioId") Long funcionarioId, Pageable pageable);
}