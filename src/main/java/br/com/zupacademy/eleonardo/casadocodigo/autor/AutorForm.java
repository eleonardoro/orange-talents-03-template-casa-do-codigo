package br.com.zupacademy.eleonardo.casadocodigo.autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class AutorForm {

	@NotEmpty
	private String nome;

	@NotEmpty
	@Email
	private String email;

	@NotEmpty
	@Size(max = 400)
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