package br.com.zupacademy.eleonardo.casadocodigo.categoria;

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

import br.com.zupacademy.eleonardo.casadocodigo.validacoes.ProibeNomeDuplicadoCategoriaValidator;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	private CategoriaRepository categoriaRepository;
	private ProibeNomeDuplicadoCategoriaValidator proibeNomeDuplicadoCategoriaValidator;

	@Autowired
	public CategoriaController(CategoriaRepository categoriaRepository,
			ProibeNomeDuplicadoCategoriaValidator proibeNomeDuplicadoCategoriaValidator) {
		this.categoriaRepository = categoriaRepository;
		this.proibeNomeDuplicadoCategoriaValidator = proibeNomeDuplicadoCategoriaValidator;
	}

	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(proibeNomeDuplicadoCategoriaValidator);
	}

	@PostMapping
	public ResponseEntity<CategoriaDto> cadastrar(@RequestBody @Valid CategoriaForm form,
			UriComponentsBuilder uriBuilder) {
		Categoria categoria = form.converter();
		categoriaRepository.save(categoria);

		return ResponseEntity.ok().body(categoria.converterToDTO());
	}

}