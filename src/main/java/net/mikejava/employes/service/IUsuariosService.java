package net.mikejava.employes.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import net.mikejava.employes.model.Usuario;


public interface IUsuariosService {	
	
	void guardarUsuario(Usuario usuario);	
	void eliminarUsuario(Integer idUsuario);	
	List<Usuario> buscarTodosUsuarios();
	Page<Usuario> buscarTodosUsuarios(Pageable page);
	Usuario buscarPorUsername(String username);
}
