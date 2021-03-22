package br.com.zupacademy.eleonardo.casadocodigo.livro;

import java.time.LocalDate;

public class LivroResponse {

	private Long id;
	private String titulo;
	private String isbn;
	private LocalDate dataPublicacao;

	public LivroResponse(Long id, String titulo, String isbn, LocalDate dataPublicacao) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
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