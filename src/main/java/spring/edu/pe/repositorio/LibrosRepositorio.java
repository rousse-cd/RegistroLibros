package spring.edu.pe.repositorio;

import org.springframework.data.repository.CrudRepository;

import spring.edu.pe.modelo.Libros;

public interface LibrosRepositorio extends CrudRepository<Libros, Integer> {

}
