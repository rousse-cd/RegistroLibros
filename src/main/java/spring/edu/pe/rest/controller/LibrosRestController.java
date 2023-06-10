package spring.edu.pe.rest.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import spring.edu.pe.modelo.Libros;
import spring.edu.pe.servicios.LibrosServicio;

@RestController
@RequestMapping("/rest/libros")
public class LibrosRestController {

	@Autowired
	private LibrosServicio servicio;
	
	@GetMapping
	public ResponseEntity<Object> buscarTodo(){
		List<Libros> listaLibros = servicio.buscarTodo();
		return new ResponseEntity<> (listaLibros, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Object> buscarPorId(@PathVariable("id") int id){
			Libros libro = servicio.buscarPorId(id);
			if(libro == null)
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Libro no encontrado,"
						                          + "id proporcionado no es correcto");
			return new ResponseEntity<Object>(libro, HttpStatus.OK);

		}
	
	
	@PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Object> crear(@RequestBody Libros libro){
		servicio.crear(libro); // Registro en base de datos
		return new ResponseEntity<Object> ("Libro Creado Correctamente", HttpStatus.OK);
		
	}
	
    @PutMapping(value ="/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Object> actualizar(@PathVariable("id") int id, @RequestBody  Libros libro){
		   servicio.actualizar(libro); // Actualiza en base de datos
		   return new ResponseEntity<Object>("Funcion actualizada correctamente", HttpStatus.OK);
	
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> eliminar (@PathVariable("id") int id){
		servicio.eliminarLibros(id);
		return new ResponseEntity<Object> ("Libro eliminado correctamente", HttpStatus.OK);

	}
	
	
	
	
}
