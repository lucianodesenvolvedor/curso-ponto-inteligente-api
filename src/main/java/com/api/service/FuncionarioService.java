package com.api.service;

import java.util.Optional;

import com.api.entity.Funcionario;

public interface FuncionarioService {

	/**
	 * Persiste um funcionário na base de dados
	 * 
	 * @param funcionario
	 * @return Funcionario
	 */
	Funcionario persistir(Funcionario funcionario);
	
	/**
	 * Retorna uma Funcionario dado um CPF
	 * 
	 * @param cpf
	 * @return Optional<Funcionario>
	 */
	Optional<Funcionario> buscarPorCpf(String cpf);
	
	/**
	 * Busca e retorna um Funcionario dado um e-Mail
	 * 
	 * @param email
	 * @return Optional<Funcionario>
	 */
	Optional<Funcionario> buscarPorEmail(String email);
	
	/**
	 * Busca e retorna um Funcionario dado um id
	 * 
	 * @param id
	 * @return Optional<Funcionario>
	 */
	Optional<Funcionario> buscarPorId(Long id);
}
