package br.com.zupacademy.eleonardo.casadocodigo.estado;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.eleonardo.casadocodigo.pais.PaisRepository;

@RestController
@RequestMapping("/estados")
public class EstadoController {

	private EstadoRepository estadoRepository;
	private PaisRepository paisRepository;

	@Autowired
	public EstadoController(EstadoRepository estadoRepository, PaisRepository paisRepository) {
		this.estadoRepository = estadoRepository;
		this.paisRepository = paisRepository;
	}

	@PostMapping
	public ResponseEntity<EstadoResponse> cadastrar(@RequestBody @Valid EstadoRequest estadoRequest) {
		Estado estado = estadoRequest.converter(paisRepository);
		estadoRepository.save(estado);

		return ResponseEntity.ok().body(new EstadoResponse(estado));
	}
}