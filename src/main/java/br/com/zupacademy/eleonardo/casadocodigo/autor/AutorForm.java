package br.com.zupacademy.eleonardo.casadocodigo.autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import br.com.zupacademy.eleonardo.casadocodigo.validacoes.FormValidavel;

public class AutorForm extends FormValidavel{

	@NotEmpty
	private String nome;

	@NotEmpty
	@Email
	private String email;

	@NotEmpty
	@Size(max = 400)
	private String descricao;

	public AutorForm(@NotEmpty String nome, @NotEmpty @Email String email,
			@NotEmpty @Size(max = 400) String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	public Autor converter() {
		return new Autor(nome, email, descricao);
	}

	@Override
	public String getValorValidavel() {
		return email;
	}
}