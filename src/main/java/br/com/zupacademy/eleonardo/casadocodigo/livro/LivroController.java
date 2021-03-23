package br.com.zupacademy.eleonardo.casadocodigo.livro;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

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
	public ResponseEntity<LivroResponse> cadastrar(@RequestBody @Valid LivroRequest form,
			UriComponentsBuilder uriBuilder) {
		Livro livro = form.converter(categoriaRepository, autorRepository);
		livroRepository.save(livro);

		return ResponseEntity.ok().body(livro.converterParaLivroResponse());
	}

	@GetMapping
	public ResponseEntity<List<LivroSimplesResponse>> listaTodosLivros() {
		List<LivroSimplesResponse> livrosResponse = new ArrayList<>();

		Iterable<Livro> livros = livroRepository.findAll();

		livros.forEach(livro -> {
			livrosResponse.add(new LivroSimplesResponse(livro));
		});

		return ResponseEntity.ok(livrosResponse);
	}

	@GetMapping("/{id}")
	public ResponseEntity<LivroCompletoResponse> listaUmLivro(@PathVariable Long id) {

		System.out.println("id: " + id);

		Optional<Livro> livro = livroRepository.findById(id);

		if (!livro.isPresent())
			return ResponseEntity.notFound().build();

		return ResponseEntity.ok().body(new LivroCompletoResponse(livro.get()));
	}
}
