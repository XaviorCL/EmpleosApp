package net.mikejava.employes.service.db;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import net.mikejava.employes.model.Usuario;
import net.mikejava.employes.repository.UsuariosRepository;
import net.mikejava.employes.service.IUsuariosService;

@Service
@Primary
public class UsuariosServiceJpa implements IUsuariosService{

	
	@Autowired
	private UsuariosRepository usuariosRepo;
	
	@Override
	public void guardarUsuario(Usuario usuario) {
		
		usuariosRepo.save(usuario);	
	}

	@Override
	public void eliminarUsuario(Integer idUsuario) {
		usuariosRepo.deleteById(idUsuario);		
	}

	@Override
	public List<Usuario> buscarTodosUsuarios() {
		return usuariosRepo.findAll();
	}
	
	@Override
	public Page<Usuario> buscarTodosUsuarios(Pageable page) {
		return usuariosRepo.findAll(page);
	}

	@Override
	public Usuario buscarPorUsername(String username) {
	
		return usuariosRepo.findByUsername(username);
	}
	
}
