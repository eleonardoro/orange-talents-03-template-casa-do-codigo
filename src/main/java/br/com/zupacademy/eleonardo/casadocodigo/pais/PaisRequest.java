package br.com.zupacademy.eleonardo.casadocodigo.pais;

import javax.validation.constraints.NotEmpty;

import br.com.zupacademy.eleonardo.casadocodigo.validacoes.ValorUnico;

public class PaisRequest {

	@NotEmpty
	@ValorUnico(domainClass = Pais.class, fieldName = "nome")
	private String nome;

	public PaisRequest(@NotEmpty String nome) {
		this.nome = nome;
	}
	
	public PaisRequest() {
	}

	public Pais converter() {
		return new Pais(nome);
	}

	public String getNome() {
		return nome;
	}
}