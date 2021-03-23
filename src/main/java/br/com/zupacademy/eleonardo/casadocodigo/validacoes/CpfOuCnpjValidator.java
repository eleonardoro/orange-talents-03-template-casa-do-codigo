package br.com.zupacademy.eleonardo.casadocodigo.validacoes;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CpfOuCnpjValidator implements ConstraintValidator<CpfOuCnpj, Object> {

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		String documento = (String) value;

		if (documento.length() == 11) {// cpf
			return ValidaCpf.isCPF(documento);
		} else {// cnpj
			return ValidaCnpj.isCNPJ(documento);
		}
	}

}
