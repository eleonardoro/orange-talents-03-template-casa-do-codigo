package br.com.zupacademy.eleonardo.casadocodigo.livro;

public class LivroSimpleResponse {

	private Long id;
	private String titulo;

	public LivroSimpleResponse(Long id, String titulo) {
		this.id = id;
		this.titulo = titulo;
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}
}