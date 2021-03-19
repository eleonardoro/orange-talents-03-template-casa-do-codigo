package br.com.zupacademy.eleonardo.casadocodigo.categoria;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.zupacademy.eleonardo.casadocodigo.validacoes.RepositoryValidaDuplicidade;

public interface CategoriaRepository extends CrudRepository<Categoria, Long>, RepositoryValidaDuplicidade {

	Optional<Categoria> findByNome(String nome);

	@Override
	@Query(value = "SELECT COUNT(*) FROM autor WHERE nome = :nome") 
	int validaCampoDuplicado(String nome);
	
}