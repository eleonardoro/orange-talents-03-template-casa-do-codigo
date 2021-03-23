package br.com.zupacademy.eleonardo.casadocodigo.livro;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.eleonardo.casadocodigo.autor.AutorRepository;
import br.com.zupacademy.eleonardo.casadocodigo.categoria.CategoriaRepository;

@RestController
@RequestMapping("/livros")
public class LivroController {

	private LivroRepository livroRepository;

	private CategoriaRepository categoriaRepository;

	private AutorRepository autorRepository;

	@Autowired
	public LivroController(LivroRepository livroRepository, CategoriaRepository categoriaRepository,
			AutorRepository autorRepository) {
		this.livroRepository = livroRepository;
		this.categoriaRepository = categoriaRepository;
		this.autorRepository = autorRepository;
	}

	@PostMapping
	public ResponseEntity<LivroResponse> cadastrar(@RequestBody @Valid LivroRequest livroRequest) {
		Livro livro = livroRequest.converter(categoriaRepository, autorRepository);
		livroRepository.save(livro);

		return ResponseEntity.ok().body(new LivroResponse(livro));
	}
}
