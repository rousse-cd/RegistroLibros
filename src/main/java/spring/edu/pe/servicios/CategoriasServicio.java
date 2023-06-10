package spring.edu.pe.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.edu.pe.modelo.Categoria;
import spring.edu.pe.repositorio.CategoriaRepositorio;

import javax.transaction.Transactional;

@Service
@Transactional
public class CategoriasServicio {
	
	@Autowired // Inyección de dependencia
	private CategoriaRepositorio categoriarepositorio;
	
	public CategoriasServicio() {
		
	}
	
	public List<Categoria> buscarTodo(){
		return (List<Categoria>) categoriarepositorio.findAll();
	}

	public Categoria crear(Categoria categoria) {
		return categoriarepositorio.save(categoria);
		
	}
	
	public Categoria actualizar(Categoria categoriaActualizar) {
		
		// primero realizamos la búsqueda de películas
		Categoria categoriaActual = categoriarepositorio.findById(categoriaActualizar.getIdCategoria()).get();
		
		categoriaActual.setIdCategoria(categoriaActualizar.getIdCategoria());
		categoriaActual.setNombre(categoriaActualizar.getNombre());
		
		Categoria categoriaActualizado = categoriarepositorio.save(categoriaActual);
		return categoriaActualizado;
	}
	
	public Categoria buscarPorId(Integer id) {
		
		return categoriarepositorio.findById(id).get();
		
	}
	
	public void borrarPorId(Integer id) {
		
		categoriarepositorio.deleteById(id);
	}
	
	
}
