package net.mikejava.employes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.mikejava.employes.model.Usuario;

public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {
	
	Usuario findByUsername(String username);

}
