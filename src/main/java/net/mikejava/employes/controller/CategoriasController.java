package net.mikejava.employes.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import net.mikejava.employes.model.Categorias;
import net.mikejava.employes.service.ICategoriaService;

@Controller
@RequestMapping(value="/categorias")
public class CategoriasController {
	
	@Autowired
	private ICategoriaService serviceCategorias;	
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String mostrarIndex(Model model) {
		List<Categorias> lista = serviceCategorias.buscarTodas();
		model.addAttribute("categorias", lista);	
		return "categorias/listCategorias";
	}
	
	@GetMapping(value="/indexCatPaginate")
	public String motrarIndexPaginado(Model model, Pageable page) {
		Page<Categorias> lista = serviceCategorias.buscarTodas(page);
		model.addAttribute("categorias", lista);	
		return "categorias/listCategorias";		
	}
	
	// @GetMapping("/create")
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String crear(Categorias categoria, Model model) {
		return "categorias/formCategoria";
	}	
		
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String guardar(Categorias categoria,BindingResult result,RedirectAttributes attributes) {
		if (result.hasErrors()){		
			System.out.println("Existieron errores");
			return "categorias/formCategoria";
		}	
		
		// Guadamos el objeto categoria en la bd		
		serviceCategorias.guardarCategoria(categoria);
		attributes.addFlashAttribute("msg", "Los datos de la categoría fueron guardados!");
		return "redirect:/categorias/index";
	}
		
	@GetMapping("/editCat/{id}")
	public String editarCategoria(@PathVariable("id") int idCategoria, Model model) {
		Categorias categoria = serviceCategorias.buscarPorIdCategoria(idCategoria);
		model.addAttribute("categorias", categoria);
		return "categorias/formCategoria";
	}		
		
	@GetMapping("/deleteCat/{id}")
	public String eliminarCategoria(@PathVariable("id") int idCategoria,RedirectAttributes attributes) {		
		try {
			// Eliminamos la categoria.			
			serviceCategorias.eliminarCategoria(idCategoria);
			attributes.addFlashAttribute("msg", "Categoria eliminada de forma exitosa");
		}catch(Exception ex){
			attributes.addFlashAttribute("msg", "No es posible eliminar la Categoría seleccionada porque tiene referencia a otros registros.");
		}		
		return "redirect:/categorias/index";			
	}
	
}	