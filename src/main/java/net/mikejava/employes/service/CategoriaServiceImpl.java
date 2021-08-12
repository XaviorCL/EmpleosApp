package net.mikejava.employes.service;


import java.util.LinkedList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.mikejava.employes.model.Categorias;

@Service
public class CategoriaServiceImpl implements ICategoriaService{

	 List<Categorias> lista = null;
	
	
	public CategoriaServiceImpl()  {
		
		lista = new LinkedList<Categorias>();
		
		try {
			Categorias cat1 = new Categorias();
			cat1.setId(1);
			cat1.setNombre("Educacion");
			cat1.setDescripcion("Busqueda de profesores");
			
			Categorias cat2 = new Categorias();
			cat2.setId(2);
			cat2.setNombre("Ingenieria");
			cat2.setDescripcion("Busqueda de ingenieros");
			
			Categorias cat3 = new Categorias();
			cat3.setId(3);
			cat3.setNombre("Arquitectura");
			cat3.setDescripcion("´Profesionales de construccion y arquitectura");
			
			Categorias cat4 = new Categorias();
			cat4.setId(4);
			cat4.setNombre("Informatica");
			cat4.setDescripcion("Profesionales de area TI");
			
			Categorias cat5 = new Categorias();
			cat5.setId(5);
			cat5.setNombre("Cocina");
			cat5.setDescripcion("Busqueda de ched y mestre");
			
			Categorias cat6 = new Categorias();
			cat6.setId(6);
			cat6.setNombre("Transportistas");
			cat6.setDescripcion("Busqueda de choferes");
			
			lista.add(cat1);
			lista.add(cat2);
			lista.add(cat3);
			lista.add(cat4);
			lista.add(cat5);
			lista.add(cat6);
			
		}catch (Exception e){	
			
			System.out.println("Error en generar la lista de categorias "+e);
		 }
			
			
		}		
	
	
	public void guardarCategoria(Categorias categoria){
		
		lista.add(categoria);
	}
	
	public List<Categorias> buscarTodas(){		
		return lista;
	}
	
	public Categorias buscarPorIdCategoria(Integer idCategoria){		
		for(Categorias c : lista) {			
			if(c.getId() == idCategoria) {				 
				return c;			
			}
		}
		
		return null;
	}


	@Override
	public void eliminarCategoria(Integer idCategoria) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Page<Categorias> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}	
}
