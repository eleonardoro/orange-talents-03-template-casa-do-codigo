package br.com.zupacademy.eleonardo.casadocodigo.validacoes;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = TemEstadoSeTemEstadoNoPaisValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface TemEstadoSeTemEstadoNoPais {

	String message() default "{br.com.zupacademy.eleonardo.casadocodigo.beanvalidation.temestadosetemnopais}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}