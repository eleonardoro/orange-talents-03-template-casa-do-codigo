package br.com.zupacademy.eleonardo.casadocodigo.autor;

import java.time.LocalDateTime;

public class AutorResponse {

	private Long id;
	private String nome;
	private String email;
	private String descricao;
	private LocalDateTime dataCriacao;

	public AutorResponse(Long id, String nome, String email, String descricao, LocalDateTime dataCriacao) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
		this.dataCriacao = dataCriacao;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getEmail() {
		return email;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}
}