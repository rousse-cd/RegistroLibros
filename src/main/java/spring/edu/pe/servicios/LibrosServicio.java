package spring.edu.pe.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.edu.pe.modelo.Libros;
import spring.edu.pe.repositorio.LibrosRepositorio;

import javax.transaction.Transactional;

@Service
@Transactional
public class LibrosServicio {

	
	@Autowired // Inyección de dependencia
	public LibrosRepositorio librosRepositorio;
	
	public LibrosServicio() {
			
	}
	
	public List<Libros> buscarTodo(){
		return (ArrayList<Libros>) librosRepositorio.findAll();

	}
	
	public Libros buscarPorId(Integer id) {
		return librosRepositorio.findById(id).get();
	}
	
	public Libros crear(Libros libros) {
		return librosRepositorio.save(libros); // Registra una función en BD
	}
	
	public Libros actualizar (Libros libroActualizar) {
		Libros libroActual = librosRepositorio.findById(libroActualizar.getIdLibros()).get();
		libroActual.setIdLibros(libroActualizar.getIdLibros());
		libroActual.setNombre(libroActualizar.getNombre());
		libroActual.setAutor(libroActualizar.getAutor());
		libroActual.setCategoria(libroActualizar.getCategoria());
		libroActual.setEdicion(libroActualizar.getEdicion());
		libroActual.setEditorial(libroActualizar.getEditorial());
		libroActual.setImagen(libroActualizar.getImagen());
		libroActual.setFechaPublicacion(libroActualizar.getFechaPublicacion());
		libroActual.setIdioma(libroActualizar.getIdioma());
		libroActual.setFormato(libroActualizar.getFormato());
		libroActual.setPrecio(libroActualizar.getPrecio());
		
		Libros librosActualizado= librosRepositorio.save(libroActual); // Actualiza en BD
		return librosActualizado;
		
	}
	
	public void eliminarLibros(Integer id) {
		librosRepositorio.deleteById(id);
		
	}
	
	public void actualizar(int id, Libros libro) {
		
		Libros libroActual = librosRepositorio.findById(id).get();
		
		libroActual.setIdLibros(libro.getIdLibros());
		libroActual.setNombre(libro.getNombre());
		libroActual.setAutor(libro.getAutor());
		libroActual.setCategoria(libro.getCategoria());
		libroActual.setEdicion(libro.getEdicion());
		libroActual.setEditorial(libro.getEditorial());
		libroActual.setImagen(libro.getImagen());
		libroActual.setFechaPublicacion(libro.getFechaPublicacion());
		libroActual.setIdioma(libro.getIdioma());
		libroActual.setFormato(libro.getFormato());
		libroActual.setPrecio(libro.getPrecio()); 
		//funcionActual.setSala(funcion.getSala());// Aquí trae los datos de la entidad Sala
		
		librosRepositorio.save(libroActual);
		
		
	}
	
	
	
}
