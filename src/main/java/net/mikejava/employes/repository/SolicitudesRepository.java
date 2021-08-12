package net.mikejava.employes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import net.mikejava.employes.model.Solicitud;

public interface SolicitudesRepository extends JpaRepository<Solicitud, Integer> {

}
