package br.com.zupacademy.eleonardo.casadocodigo.livro;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livros")
public class LivroListagensController {

	private LivroRepository livroRepository;

	@Autowired
	public LivroListagensController(LivroRepository livroRepository) {
		this.livroRepository = livroRepository;
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
