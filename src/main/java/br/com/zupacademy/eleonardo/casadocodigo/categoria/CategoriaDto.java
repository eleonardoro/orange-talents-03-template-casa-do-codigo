package br.com.zupacademy.eleonardo.casadocodigo.categoria;

public class CategoriaDto {

	private Long id;
	private String nome;

	public CategoriaDto(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

}