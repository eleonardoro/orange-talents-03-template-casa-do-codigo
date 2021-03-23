package br.com.zupacademy.eleonardo.casadocodigo.validacoes;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.zupacademy.eleonardo.casadocodigo.cliente.ClienteRequest;
import br.com.zupacademy.eleonardo.casadocodigo.estado.Estado;

public class TemEstadoSeTemEstadoNoPaisValidator
		implements ConstraintValidator<TemEstadoSeTemEstadoNoPais, ClienteRequest> {
	@PersistenceContext
	private EntityManager manager;

	@Override
	public boolean isValid(ClienteRequest clienteRequest, ConstraintValidatorContext context) {

		Query query = manager.createQuery("select count(*) from " + Estado.class.getName() + " where pais_id =:pais");
		query.setParameter("pais", clienteRequest.getIdPais());

		Long contEstados = (Long) query.getSingleResult();

		System.out.println("Existem " + contEstados + " estados cadastrados no pais " + clienteRequest.getIdPais());

		if (contEstados == 0) // Não tem estados cadastrado, não preciso validar
			return true;
		else// Tem estado cadastrado, preciso validar se enviou algum estado
		if (clienteRequest.getIdEstado() == null)
			return false;

		return true;
	}

}