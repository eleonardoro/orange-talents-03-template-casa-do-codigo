package br.com.zupacademy.eleonardo.casadocodigo.livro;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.zupacademy.eleonardo.casadocodigo.autor.Autor;
import br.com.zupacademy.eleonardo.casadocodigo.categoria.Categoria;

public class LivroCompletoResponse {

	private Long id;
	private String titulo;
	private String resumo;
	private String sumario;
	private BigDecimal preco;
	private Integer paginas;
	private String isbn;
	private LocalDate dataPublicacao;
	private Categoria categoria;
	private Autor autor;

	public LivroCompletoResponse(Long id, String titulo, String resumo, String sumario, BigDecimal preco,
			Integer paginas, String isbn, LocalDate dataPublicacao, Categoria categoria, Autor autor) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.paginas = paginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.categoria = categoria;
		this.autor = autor;
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public Integer getPaginas() {
		return paginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public Autor getAutor() {
		return autor;
	}
}