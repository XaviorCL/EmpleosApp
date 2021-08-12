package net.mikejava.employes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.mikejava.employes.model.Usuario;
import net.mikejava.employes.service.IUsuariosService;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {
	
	@Autowired
	private IUsuariosService serviceUsuario;
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		
		//List<Vacante> lista = serviceVacantes.buscarTodas();
		//model.addAttribute("vacantes", lista);
		List<Usuario> listaUsuario = serviceUsuario.buscarTodosUsuarios();
		model.addAttribute("usuarios", listaUsuario);
		return "usuarios/listUsuarios";
	}
	@GetMapping(value="/indexUsuPaginate")
	public String motrarIndexUsuPaginado(Model model, Pageable page) {
		Page<Usuario> lista = serviceUsuario.buscarTodosUsuarios(page);
		model.addAttribute("usuarios", lista);	
		return "usuarios/listUsuarios";
	}
	
	
	@GetMapping("/delete/{id}")
	public String eliminarUsuario (@PathVariable("id") int idUsuario, RedirectAttributes attributtes) {
		
		try {
				// Eliminamos el usuario.			
				//serviceCategorias.eliminarCategoria(idCategoria);
				serviceUsuario.eliminarUsuario(idUsuario);			
				attributtes.addFlashAttribute("msg", "Usduario eliminado correctamente");
			}catch(Exception ex){
				attributtes.addFlashAttribute("msg", "El usuario no pudo ser eliminado.");
			}				
		
		return "redirect:/usuarios/index";		
	}
	
}
