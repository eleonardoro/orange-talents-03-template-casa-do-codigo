package br.com.zupacademy.eleonardo.casadocodigo.cliente;

import br.com.zupacademy.eleonardo.casadocodigo.estado.Estado;
import br.com.zupacademy.eleonardo.casadocodigo.pais.Pais;

public class ClienteResponse {

	private Long id;
	private String nome;
	private String sobrenome;
	private String email;
	private String telefone;
	private String documento;
	private String cep;
	private String endereco;
	private String complemento;
	private String cidade;
	private Pais pais;
	private Estado estado;

	public ClienteResponse(Cliente cliente) {
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.sobrenome = cliente.getSobrenome();
		this.email = cliente.getEmail();
		this.telefone = cliente.getTelefone();
		this.documento = cliente.getDocumento();
		this.cep = cliente.getCep();
		this.endereco = cliente.getEndereco();
		this.complemento = cliente.getComplemento();
		this.cidade = cliente.getCidade();
		this.pais = cliente.getPais();
		this.estado = cliente.getEstado();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getDocumento() {
		return documento;
	}

	public String getCep() {
		return cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public Pais getPais() {
		return pais;
	}

	public Estado getEstado() {
		return estado;
	}
}