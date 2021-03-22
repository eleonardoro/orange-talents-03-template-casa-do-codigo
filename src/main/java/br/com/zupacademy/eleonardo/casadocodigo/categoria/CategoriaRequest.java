package br.com.zupacademy.eleonardo.casadocodigo.categoria;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoriaRequest {

	@NotEmpty
	private String nome;

	@JsonCreator
	public CategoriaRequest(@NotEmpty @JsonProperty("nome") String nome) {
		this.nome = nome;
	}

	public Categoria converter() {
		return new Categoria(nome);
	}

	public String getNome() {
		return nome;
	}
}