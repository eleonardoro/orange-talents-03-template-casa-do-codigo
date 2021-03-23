package br.com.zupacademy.eleonardo.casadocodigo.autor;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autores")
public class AutorController {

	private AutorRepository autorRepository;

	@Autowired
	public AutorController(AutorRepository autorRepository) {
		this.autorRepository = autorRepository;
	}

	@PostMapping
	public ResponseEntity<AutorResponse> cadastrar(@RequestBody @Valid AutorRequest form) {
		Autor autor = form.converter();
		autorRepository.save(autor);

		return ResponseEntity.ok().body(autor.converterToDTO());
	}

}