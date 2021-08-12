package net.mikejava.employes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.mikejava.employes.model.Vacante;

public interface VacantesRepository extends JpaRepository<Vacante, Integer> {
	
	List<Vacante> findByEstatus(String estatus); 
	List<Vacante> findByDestacadoAndEstatusOrderByIdDesc(Integer destacado, String estatus); 
	
	List<Vacante> findBySalarioBetweenOrderBySalarioDesc(double s1, double s2);
	
	List<Vacante> findByEstatusIn(String[] estatus);
}
