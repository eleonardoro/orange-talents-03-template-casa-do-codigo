package br.com.zupacademy.eleonardo.casadocodigo.validacoes;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.eleonardo.casadocodigo.categoria.Categoria;
import br.com.zupacademy.eleonardo.casadocodigo.categoria.CategoriaRepository;
import br.com.zupacademy.eleonardo.casadocodigo.categoria.CategoriaRequest;

@Component
public class ProibeNomeDuplicadoCategoriaValidator implements Validator {

	private CategoriaRepository categoriaRepository;

	@Autowired
	public ProibeNomeDuplicadoCategoriaValidator(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return CategoriaRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		if (errors.hasErrors())
			return;

		CategoriaRequest categoriaRequest = (CategoriaRequest) target;

		Optional<Categoria> categoria = categoriaRepository.findByNome(categoriaRequest.getNome());

		if (categoria.isPresent()) {
			errors.rejectValue("nome", null,
					"Já existe uma outra categoria cadastrada com este nome: " + categoriaRequest.getNome());
		}
	}

}