package br.com.zupacademy.eleonardo.casadocodigo.validacoes;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.eleonardo.casadocodigo.autor.Autor;
import br.com.zupacademy.eleonardo.casadocodigo.autor.AutorForm;
import br.com.zupacademy.eleonardo.casadocodigo.autor.AutorRepository;

@Component
public class ProibeEmailDuplicadoAutorValidator implements Validator {

	private AutorRepository autorRepository;

	@Autowired
	public ProibeEmailDuplicadoAutorValidator(AutorRepository autorRepository) {
		this.autorRepository = autorRepository;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return AutorForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		if (errors.hasErrors())
			return;

		AutorForm autorForm = (AutorForm) target;

		Optional<Autor> autor = autorRepository.findByEmail(autorForm.getEmail());

		if (autor.isPresent()) {
			errors.rejectValue("email", null,
					"Já existe um(a) outro(a) autor(a) cadastrado(a) com este e-mail: " + autorForm.getEmail());
		}

	}

}