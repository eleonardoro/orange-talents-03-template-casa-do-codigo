package br.com.zupacademy.eleonardo.casadocodigo.cliente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.zupacademy.eleonardo.casadocodigo.estado.Estado;
import br.com.zupacademy.eleonardo.casadocodigo.pais.Pais;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true)
	private String nome;

	@Column(nullable = false)
	private String sobrenome;

	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false)
	private String telefone;

	@Column(nullable = false, unique = true)
	private String documento;

	@Column(nullable = false)
	private String cep;

	@Column(nullable = false)
	private String endereco;

	@Column(nullable = false)
	private String complemento;

	@Column(nullable = false)
	private String cidade;

	@ManyToOne
	private Pais pais;

	@ManyToOne
	private Estado estado;

	@Deprecated
	public Cliente() {
	}

	public Cliente(String nome, String sobrenome, String email, String telefone, String documento, String cep,
			String endereco, String complemento, String cidade, Pais pais, Estado estado) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.telefone = telefone;
		this.documento = documento;
		this.cep = cep;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.pais = pais;
		this.estado = estado;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}