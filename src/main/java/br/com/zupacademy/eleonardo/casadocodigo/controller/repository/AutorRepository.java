package br.com.zupacademy.eleonardo.casadocodigo.controller.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.zupacademy.eleonardo.casadocodigo.modelo.Autor;

public interface AutorRepository extends CrudRepository<Autor, Long> {
}