package spring.edu.pe.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import spring.edu.pe.modelo.Categoria;

public interface CategoriaRepositorio extends CrudRepository<Categoria, Integer> {

	@Query(value = "SELECT a FROM Pelicula a WHERE a.nombre =?1")
	public List<Categoria> buscarCategoriasPorNombre(String nombre);
	
	
	@Query(value = "SELECT a FROM Pelicula a WHERE a.nombre like CONCAT(?1, '%')")
	public List<Categoria> buscarCategoriaLikeNombre(String nombre);
	
}
