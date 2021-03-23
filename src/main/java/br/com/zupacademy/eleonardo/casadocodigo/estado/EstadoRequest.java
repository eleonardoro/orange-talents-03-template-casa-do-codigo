package br.com.zupacademy.eleonardo.casadocodigo.estado;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.eleonardo.casadocodigo.pais.Pais;
import br.com.zupacademy.eleonardo.casadocodigo.pais.PaisRepository;
import br.com.zupacademy.eleonardo.casadocodigo.validacoes.ValorUnico;

public class EstadoRequest {

	@NotEmpty
	@ValorUnico(domainClass = Estado.class, fieldName = "nome")
	private String nome;

	@NotNull
	private Long idPais;

	public EstadoRequest(@NotEmpty String nome, @NotNull Long idPais) {
		this.nome = nome;
		this.idPais = idPais;
	}

	public Estado converter(PaisRepository paisRepository) {
		Pais pais = paisRepository.findById(idPais).get();
		
		return new Estado(nome, pais);
	}

	public String getNome() {
		return nome;
	}

	public Long getIdPais() {
		return idPais;
	}
}