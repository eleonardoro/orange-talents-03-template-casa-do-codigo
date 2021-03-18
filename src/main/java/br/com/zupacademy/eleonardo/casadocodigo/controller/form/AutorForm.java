package br.com.zupacademy.eleonardo.casadocodigo.controller.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.zupacademy.eleonardo.casadocodigo.modelo.Autor;

public class AutorForm {

	@NotNull
	@NotEmpty
	private String nome;

	@NotNull
	@NotEmpty
	@Email
	private String email;

	@NotNull
	@NotEmpty
	@Length(max = 400)
	private String descricao;

	public Autor converter() {
		return new Autor(nome, email, descricao);
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}