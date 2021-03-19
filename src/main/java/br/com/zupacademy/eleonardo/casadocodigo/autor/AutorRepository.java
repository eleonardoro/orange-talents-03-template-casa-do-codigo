package br.com.zupacademy.eleonardo.casadocodigo.autor;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.zupacademy.eleonardo.casadocodigo.validacoes.RepositoryValidaDuplicidade;

public interface AutorRepository extends CrudRepository<Autor, Long>, RepositoryValidaDuplicidade {
	
	Optional<Autor> findByEmail(String email);

	@Override
	@Query(value = "SELECT COUNT(*) FROM autor WHERE nome = :nome")
	int validaCampoDuplicado(String campo);
	
	
}