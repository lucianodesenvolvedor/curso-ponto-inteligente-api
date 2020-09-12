package com.api.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import lombok.Data;

@Data
public class CadastroPJDto {

	private Long id;
	@NotEmpty(message = "Nome não pode ser vazio.")
	@Length(min = 3, max = 45, message = "Nome deve conter entre 3 e 45 caracteres.")
	private String nome;
	@NotEmpty(message = "Email não pode ser vazio.")
	@Length(min = 8, max = 75, message = "Email deve conter entre 10 e 75 caracteres.")
	@Email(message="Email inválido.")
	private String email;
	@NotEmpty(message = "Senha não pode ser vazia.")
	private String senha;
	@NotEmpty(message = "Razão Social não pode ser vazio.")
	@Length(min = 5, max = 45, message = "Razão Social deve conter entre 3 e 45 caracteres.")
	private String razaoSocial;
	@NotEmpty(message = "CPF não pode ser vazio.")
	@CPF(message="CPF inválido")
	private String cpf;
	@NotEmpty(message = "CNPJ não pode ser vazio.")
	@CNPJ(message = "CNPJ inválido.")
	private String cnpj;
}
