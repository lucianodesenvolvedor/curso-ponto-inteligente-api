package com.api.entity;

import java.io.Serializable;
import java.util.Date;

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
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.api.enums.TipoEnum;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
@Table(name = "lancamento")
public class Lancamento implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "data", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;
	@Column(name = "descricao", length = 100, nullable = false)
	private String descricao;
	@Column(name = "localizacao", length = 100, nullable = false)
	private String localizacao;
	@Column(name = "data_criacao", nullable = false)
	private Date dataCriacao;
	@Column(name = "data_atualizacao", nullable = false)
	private Date dataAtualizacao;
	@Column(name = "tipo", nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoEnum tipo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "funcionario_id")
	private Funcionario funcionario;
	
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
}
