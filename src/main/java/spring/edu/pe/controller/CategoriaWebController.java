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

import spring.edu.pe.modelo.Categoria;
import spring.edu.pe.servicios.CategoriasServicio;

@Controller
@RequestMapping("/categorias")
public class CategoriaWebController {

	@Autowired // inyeccción de dependencia
	private CategoriasServicio servicio;
	
	@RequestMapping("/listarTodo")
	public String listarCategorias(Model model) {
		List<Categoria> listaCategorias = servicio.buscarTodo();
		
		System.out.println("LISTA DE CATEGORIAS : " + listaCategorias);
		
		model.addAttribute("listaCategorias", listaCategorias);
		return "/moduloCategorias/listarTodo";
	}
	

	@RequestMapping("/nuevo")
	public String nuevaCategoria(Model model) {
		Categoria categoria = new Categoria();
		model.addAttribute("categoria", categoria);
		return "/moduloCategorias/nuevaCategoria";
		
	}
	
	@RequestMapping(value = "/guardar" , method = RequestMethod.POST)
	public String crearCategoria(@ModelAttribute("categoria") Categoria categoria) {
		    servicio.crear(categoria);
		    return "redirect:/categorias/listarTodo";
	
	}
	
	@RequestMapping(value = "/actualizar/{id}")
	public ModelAndView editarCategoria(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("/moduloCategorias/editarCategoria");
	    Categoria categoria = servicio.buscarPorId(id);
	    mav.addObject("categoria", categoria);
	    return mav;
	}
	
	
	@RequestMapping(value ="/eliminar/{id}")
	public String eliminarCategoria(@PathVariable(name = "id") int id) {
		  servicio.borrarPorId(id);
		 return "redirect:/categorias/listarTodo";
		
	}
	
	
}

	