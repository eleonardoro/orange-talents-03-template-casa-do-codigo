package br.com.zupacademy.eleonardo.casadocodigo.pais;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paises")
public class PaisController {

	private PaisRepository paisRepository;

	@Autowired
	public PaisController(PaisRepository paisRepository) {
		super();
		this.paisRepository = paisRepository;
	}

	@PostMapping
	public ResponseEntity<PaisResponse> cadastrar(@RequestBody @Valid PaisRequest paisRequest) {
		Pais pais = paisRequest.converter();
		paisRepository.save(pais);

		return ResponseEntity.ok().body(new PaisResponse(pais));
	}
}