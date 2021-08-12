package net.mikejava.employes.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import net.mikejava.employes.model.Categorias;


public interface ICategoriaService {
	
	List<Categorias> buscarTodas();
	Categorias buscarPorIdCategoria(Integer idCategoria);
	void guardarCategoria(Categorias categoria);
	void eliminarCategoria(Integer idCategoria);
	Page <Categorias> buscarTodas(Pageable page);
}
