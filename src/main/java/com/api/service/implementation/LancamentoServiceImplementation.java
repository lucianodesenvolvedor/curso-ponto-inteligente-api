package com.api.service.implementation;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.api.entity.Lancamento;
import com.api.repository.LancamentoRepository;
import com.api.service.LancamentoService;

public class LancamentoServiceImplementation implements LancamentoService {

	private static final Logger log = LoggerFactory.getLogger(LancamentoServiceImplementation.class);

	@Autowired
	private LancamentoRepository lancamentoRepository;

	@Override
	public Page<Lancamento> buscarPorFuncionarioId(Long id, Pageable pageable) {
		log.info("Buscando lançamentos para o funcionário de ID {}", id);
		return this.lancamentoRepository.findByFuncionarioId(id, pageable);
	}

	@Override
	public Optional<Lancamento> buscarPorId(Long id) {
		log.info("Buscando lançamentos por ID {}", id);
		return this.lancamentoRepository.findById(id);
	}

	@Override
	public Lancamento persistir(Lancamento lancamento) {
		log.info("Persistindo um lançamento na base dados {}", lancamento);
		return this.lancamentoRepository.save(lancamento);
	}

	@Override
	public void remover(Long id) {
		log.info("Removendo um lançamento da base dados {}", "");
		this.lancamentoRepository.deleteById(id);
	}

}
