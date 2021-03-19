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

import br.com.zupacademy.eleonardo.casadocodigo.validacoes.ProibeEmailDuplicadoAutorValidator;

@RestController
@RequestMapping("/autores")
public class AutorController {

	private AutorRepository autorRepository;
	private ProibeEmailDuplicadoAutorValidator proibeEmailDuplicadoAutorValidator;

	@Autowired
	public AutorController(AutorRepository autorRepository,
			ProibeEmailDuplicadoAutorValidator proibeEmailDuplicadoAutorValidator) {
		this.autorRepository = autorRepository;
		this.proibeEmailDuplicadoAutorValidator = proibeEmailDuplicadoAutorValidator;
	}

	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(proibeEmailDuplicadoAutorValidator);
	}

	@PostMapping
	public ResponseEntity<AutorDto> cadastrar(@RequestBody @Valid AutorForm form, UriComponentsBuilder uriBuilder) {
		Autor autor = form.converter();
		autorRepository.save(autor);

		return ResponseEntity.ok().body(autor.converterToDTO());
	}

}