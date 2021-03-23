package br.com.zupacademy.eleonardo.casadocodigo.estado;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface EstadoRepository extends CrudRepository<Estado, Long> {

	List<Estado> findAllByPais_id(Long id);
}