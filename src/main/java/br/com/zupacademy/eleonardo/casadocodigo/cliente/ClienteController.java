package br.com.zupacademy.eleonardo.casadocodigo.cliente;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.eleonardo.casadocodigo.estado.EstadoRepository;
import br.com.zupacademy.eleonardo.casadocodigo.pais.PaisRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	ClienteRepository clienteRepository;
	PaisRepository paisRepository;
	EstadoRepository estadoRepository;

	@Autowired
	public ClienteController(ClienteRepository clienteRepository, PaisRepository paisRepository,
			EstadoRepository estadoRepository) {
		this.clienteRepository = clienteRepository;
		this.paisRepository = paisRepository;
		this.estadoRepository = estadoRepository;
	}

	@PostMapping
	public ResponseEntity<ClienteResponse> cadastrar(@RequestBody @Valid ClienteRequest clienteRequest) {
		Cliente cliente = clienteRequest.converter(paisRepository, estadoRepository);
		clienteRepository.save(cliente);

		return ResponseEntity.ok(new ClienteResponse(cliente));
	}
}