package net.mikejava.employes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import net.mikejava.employes.model.Categorias;

//public interface CategoriaRepository extends CrudRepository<Categorias, Integer> {
public interface CategoriaRepository extends JpaRepository<Categorias, Integer> {
	
	
}
