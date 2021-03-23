package br.com.zupacademy.eleonardo.casadocodigo.livro;

import java.time.LocalDate;

public class LivroResponse {

	private Long id;
	private String titulo;
	private String isbn;
	private LocalDate dataPublicacao;

	public LivroResponse(Livro livro) {
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
		this.isbn = livro.getIsbn();
		this.dataPublicacao = livro.getDataPublicacao();
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}
}