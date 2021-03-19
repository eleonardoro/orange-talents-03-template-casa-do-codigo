package br.com.zupacademy.eleonardo.casadocodigo.categoria;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.zupacademy.eleonardo.casadocodigo.validacoes.FormValidavel;

public class CategoriaRequest extends FormValidavel{

	@NotEmpty
	private String nome;

	@JsonCreator
	public CategoriaRequest(@NotEmpty @JsonProperty("nome") String nome) {
		this.nome = nome;
	}

	public Categoria converter() {
		return new Categoria(nome);
	}

	@Override
	public String getValorValidavel() {
		return nome;
	}
}