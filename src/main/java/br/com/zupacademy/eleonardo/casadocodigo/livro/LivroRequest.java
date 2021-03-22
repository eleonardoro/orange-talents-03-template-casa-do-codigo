package br.com.zupacademy.eleonardo.casadocodigo.livro;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.zupacademy.eleonardo.casadocodigo.autor.Autor;
import br.com.zupacademy.eleonardo.casadocodigo.autor.AutorRepository;
import br.com.zupacademy.eleonardo.casadocodigo.categoria.Categoria;
import br.com.zupacademy.eleonardo.casadocodigo.categoria.CategoriaRepository;
import br.com.zupacademy.eleonardo.casadocodigo.validacoes.UniqueValue;

public class LivroRequest {

	@NotEmpty
	@UniqueValue(domainClass = Livro.class, fieldName = "titulo")
	private String titulo;

	@NotEmpty
	@Size(max = 500)
	private String resumo;

	@NotEmpty
	private String sumario;

	@NotNull
	@Min(value = 20)
	private BigDecimal preco;

	@NotNull
	@Min(value = 100)
	private Integer paginas;

	@NotEmpty
	@UniqueValue(domainClass = Livro.class, fieldName = "isbn")
	private String isbn;

	@NotNull
	@Future
	@JsonFormat(pattern = "YYYY-MM-dd", shape = Shape.STRING)
	private LocalDate dataPublicacao;

	@NotNull
	private Long idCategoria;

	@NotNull
	private Long idAutor;

	public LivroRequest(@NotEmpty String titulo, @NotEmpty @Size(max = 500) String resumo, @NotEmpty String sumario,
			@NotNull @Min(20) BigDecimal preco, @NotNull @Min(100) Integer paginas, @NotEmpty String isbn,
			@NotNull @Future LocalDate dataPublicacao, @NotNull Long idCategoria, @NotNull Long idAutor) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.paginas = paginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.idCategoria = idCategoria;
		this.idAutor = idAutor;
	}

	public Livro converter(CategoriaRepository categoriaRepository, AutorRepository autorRepository) {
		Categoria categoria = categoriaRepository.findById(idCategoria).get();

		System.out.println(categoria.toString());

		Autor autor = autorRepository.findById(idAutor).get();

		return new Livro(titulo, resumo, sumario, preco, paginas, isbn, dataPublicacao, categoria, autor);
	}
}
