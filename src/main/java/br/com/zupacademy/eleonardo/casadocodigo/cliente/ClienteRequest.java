package br.com.zupacademy.eleonardo.casadocodigo.cliente;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.eleonardo.casadocodigo.estado.Estado;
import br.com.zupacademy.eleonardo.casadocodigo.estado.EstadoRepository;
import br.com.zupacademy.eleonardo.casadocodigo.pais.Pais;
import br.com.zupacademy.eleonardo.casadocodigo.pais.PaisRepository;
import br.com.zupacademy.eleonardo.casadocodigo.validacoes.CpfOuCnpj;
import br.com.zupacademy.eleonardo.casadocodigo.validacoes.TemEstadoSeTemEstadoNoPais;
import br.com.zupacademy.eleonardo.casadocodigo.validacoes.ValorUnico;

@TemEstadoSeTemEstadoNoPais
public class ClienteRequest {

	@NotEmpty
	private String nome;

	@NotEmpty
	private String sobrenome;

	@NotEmpty
	@Email
	@ValorUnico(domainClass = Cliente.class, fieldName = "email")
	private String email;

	@NotEmpty
	private String telefone;

	@NotEmpty
	@CpfOuCnpj
	@ValorUnico(domainClass = Cliente.class, fieldName = "documento")
	private String documento;

	@NotEmpty
	private String cep;

	@NotEmpty
	private String endereco;

	@NotEmpty
	private String complemento;

	@NotEmpty
	private String cidade;

	@NotNull
	private Long idPais;

	private Long idEstado;

	public ClienteRequest(@NotEmpty @Email String email, @NotEmpty String nome, @NotEmpty String sobrenome,
			@NotEmpty String documento, @NotEmpty String endereco, @NotEmpty String complemento,
			@NotEmpty String cidade, @NotNull Long idPais, @NotNull Long idEstado, @NotEmpty String telefone,
			@NotEmpty String cep) {
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.idPais = idPais;
		this.idEstado = idEstado;
		this.telefone = telefone;
		this.cep = cep;
	}

	public Cliente converter(PaisRepository paisRepository, EstadoRepository estadoRepository) {
		Pais pais = paisRepository.findById(idPais).get();

		Estado estado = estadoRepository.findById(idEstado).get();

		return new Cliente(nome, sobrenome, email, telefone, documento, cep, endereco, complemento, cidade, pais,
				estado);
	}

	public Long getIdPais() {
		return idPais;
	}

	public Long getIdEstado() {
		return idEstado;
	}
}