package br.com.zupacademy.eleonardo.casadocodigo.validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProibeCampoDuplicadoValidator implements Validator {

	private RepositoryValidaDuplicidade repository;

	@Autowired
	public ProibeCampoDuplicadoValidator(RepositoryValidaDuplicidade repository) {
		this.repository = repository;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return FormValidavel.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		if (errors.hasErrors())
			return;

		FormValidavel form = (FormValidavel) target;

		if (repository.validaCampoDuplicado(form.getValorValidavel()) > 0) {
			errors.rejectValue("email", null, "Já existe outro cadastrado com este valor: " + form.getValorValidavel());
		}

	}

}