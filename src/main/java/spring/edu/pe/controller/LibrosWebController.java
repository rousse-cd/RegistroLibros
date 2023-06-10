package spring.edu.pe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import spring.edu.pe.modelo.Libros;
import spring.edu.pe.servicios.LibrosServicio;

@Controller
@RequestMapping("/libros")
public class LibrosWebController {
    @Autowired // inyeccción de dependencia
	private LibrosServicio servicio;
	
	@RequestMapping("/listarTodo")
	public String listarLibros(Model model) {
		List<Libros> listaLibros = servicio.buscarTodo();
		
		System.out.println("LISTA DE Libros : " + listaLibros);
		
		model.addAttribute("listaFunciones", listaLibros);
		return "/moduloLibros/listarTodo";
	}
	

	@RequestMapping("/nuevo")
	public String nuevaLibro(Model model) {
		Libros libro = new Libros();
		model.addAttribute("libro", libro);
		return "/moduloLibro/nuevaLibro";
		
	}
	
	@RequestMapping(value = "/guardar" , method = RequestMethod.POST)
	public String crearLibro(@ModelAttribute("libro") Libros libro) {
		    servicio.crear(libro);
		    return "redirect:/libros/listarTodo";
	
	}
	
	@RequestMapping(value = "/actualizar/{id}")
	public ModelAndView editarLibro(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("/moduloLibro/editarLibro");
	    Libros libro = servicio.buscarPorId(id);
	    mav.addObject("libro", libro);
	    return mav;
	}
	
	
	@RequestMapping(value ="/eliminar/{id}")
	public String eliminarLibro(@PathVariable(name = "id") int id) {
		  servicio.eliminarLibros(id);
		 return "redirect:/libros/listarTodo";
		
	}
	
}
