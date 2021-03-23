package br.com.zupacademy.eleonardo.casadocodigo.livro;

public class LivroSimplesResponse {

	private Long id;
	private String titulo;

	public LivroSimplesResponse(Long id, String titulo) {
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