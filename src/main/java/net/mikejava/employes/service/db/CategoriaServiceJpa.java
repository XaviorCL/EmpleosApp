package net.mikejava.employes.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.mikejava.employes.model.Categorias;
import net.mikejava.employes.repository.CategoriaRepository;
import net.mikejava.employes.service.ICategoriaService;

@Service
@Primary
public class CategoriaServiceJpa implements ICategoriaService {

	@Autowired
	private CategoriaRepository categoriasRepo;
	
	
	public void guardarCategoria(Categorias categoria) {
		categoriasRepo.save(categoria);

	}
	
	public List<Categorias> buscarTodas() {		
		return categoriasRepo.findAll();
	}

	
	public Categorias buscarPorIdCategoria(Integer idCategoria) {
		Optional<Categorias> optional = categoriasRepo.findById(idCategoria);		
		if(optional.isPresent()) {
			return optional.get();			
		}		
		return null;
	}
	
	@Override
	public void eliminarCategoria(Integer idCategoria) {
		categoriasRepo.deleteById(idCategoria);
		
	}

	@Override
	public Page<Categorias> buscarTodas(Pageable page) {
		return categoriasRepo.findAll(page);
	}
}
