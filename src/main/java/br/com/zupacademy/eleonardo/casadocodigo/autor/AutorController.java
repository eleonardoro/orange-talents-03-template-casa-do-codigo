package br.com.zupacademy.eleonardo.casadocodigo.autor;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zupacademy.eleonardo.casadocodigo.validacoes.ProibeCampoDuplicadoValidator;

@RestController
@RequestMapping("/autores")
public class AutorController {

	private AutorRepository autorRepository;
	private ProibeCampoDuplicadoValidator proibeCampoDuplicadoValidator;

	@Autowired
	public AutorController(AutorRepository autorRepository,
			ProibeCampoDuplicadoValidator proibeCampoDuplicadoValidator) {
		this.autorRepository = autorRepository;
		this.proibeCampoDuplicadoValidator = proibeCampoDuplicadoValidator;
	}

	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(proibeCampoDuplicadoValidator);
	}

	@PostMapping
	public ResponseEntity<AutorResponse> cadastrar(@RequestBody @Valid AutorRequest form, UriComponentsBuilder uriBuilder) {
		Autor autor = form.converter();
		autorRepository.save(autor);

		return ResponseEntity.ok().body(autor.converterToDTO());
	}

}