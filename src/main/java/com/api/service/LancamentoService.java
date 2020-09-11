package com.api.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.api.entity.Lancamento;

public interface LancamentoService {

	/**
	 * Retorna uma lista paginada de lançamentos de um determinado funcionario
	 * 
	 * @param funcionarioId
	 * @param pageRequest
	 * @return Page<Lancamento>
	 */
	Page<Lancamento> buscarPorFuncionarioId(Long id, Pageable pageable);

	/**
	 * Retorna um lançamento por ID
	 * 
	 * @param id
	 * @return Optional<Lancamento>
	 */
	Optional<Lancamento> buscarPorId(Long id);

	/**
	 * Persisti um lançamento na base de dados
	 * 
	 * @param lancamento
	 * @return Lancamento
	 */
	Lancamento persistir(Lancamento lancamento);

	/**
	 * Remove um lançamento na base de dados
	 * 
	 * @param id
	 */
	void remover(Long id);
}
