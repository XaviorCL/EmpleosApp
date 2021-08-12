package net.mikejava.employes.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="categorias")

public class Categorias {

	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String Descripcion;
	
	@OneToOne
	@JoinColumn(name="id")
	private Vacante vacante;		
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public Vacante getVacante() {
		return vacante;
	}
	public void setVacante(Vacante vacante) {
		this.vacante = vacante;
	}
	@Override
	public String toString() {
		return "Categorias [id=" + id + ", nombre=" + nombre + ", Descripcion=" + Descripcion + ", vacante=" + vacante
				+ "]";
	}	
	
}
