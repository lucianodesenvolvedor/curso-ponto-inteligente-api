package com.api.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.api.enums.PerfilEnum;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
@Table(name = "funcionario")
public class Funcionario implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nome", length = 45, nullable = false)
	private String nome;
	@Column(name = "email", length = 75, nullable = false, unique = true)
	private String email;
	@Column(name = "senha", length = 45, nullable = false)
	private String senha;
	@Column(name = "cpf", length = 15, nullable = false)
	private String cpf;
	@Column(name = "valor_hora")
	private BigDecimal valorHora;
	@Column(name = "quantidade_horas_trabalho_dia")
	private float quantidadeHorasTrabalhoDia;
	@Column(name = "quantidade_horas_almoco")
	private float quantidadeHorasAlmoco;
	@Column(name = "perfil")
	@Enumerated(EnumType.STRING)
	private PerfilEnum perfil;
	@Column(name = "data_criacao", nullable = false)
	private Date dataCriacao;
	@Column(name = "data_atualizacao", nullable = false)
	private Date dataAtualizacao;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "empresa_id")
	private Empresa empresa;
	
	@OneToMany(mappedBy = "funcionario",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Lancamento> lancamentos;
	
	@PrePersist
	public void prePersit() {
		final Date atual = new Date();
		dataCriacao = atual;
		dataAtualizacao = atual;
	}
	
	@PreUpdate
	public void preUpdate() {
		dataAtualizacao = new Date();
	}
	
	@Transient
	public Optional<BigDecimal> getValorHoraOpt(){
		return Optional.ofNullable(valorHora);
	}
	
	@Transient
	public Optional<Float> getQuantidadeHorasTrabalhoDiaOpt(){
		return Optional.ofNullable(quantidadeHorasTrabalhoDia);
	}
	
	@Transient
	public Optional<Float> getQuantidadeHorasAlmocoOpt(){
		return Optional.ofNullable(quantidadeHorasAlmoco);
	}
}
