package br.com.zupacademy.eleonardo.casadocodigo.controller.dto;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;

import br.com.zupacademy.eleonardo.casadocodigo.modelo.Autor;

public class AutorDto {

	private Long id;
	private String nome;
	private String email;
	private String descricao;
	private LocalDateTime dataCriacao;

	public AutorDto(Autor autor) {
		this.id = autor.getId();
		this.nome = autor.getNome();
		this.email = autor.getEmail();
		this.descricao = autor.getDescricao();
		this.dataCriacao = autor.getDataCriacao();
	}

	public static Page<AutorDto> converter(Page<Autor> autors) {
		return autors.map(AutorDto::new);
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