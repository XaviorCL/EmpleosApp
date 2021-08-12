package net.mikejava.employes.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.mikejava.employes.model.Vacante;

@Service
public class VacanteServiceImpl implements IVacantesService{

	List<Vacante> lista = null;
	
	public VacanteServiceImpl() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		lista = new LinkedList<Vacante>();
		
		try {
			// Se crea primera oferta de trabajo
			Vacante vacante1 = new Vacante();
			vacante1.setId(1);
			vacante1.setNombre("Gamer profesional GTV");
			vacante1.setDescripcion("Se requiere un gamer pro para probar juegos de ultima generacion y dar idea de nuevos juegos");
			vacante1.setFecha(sdf.parse("08-02-2020"));
			vacante1.setSalario(9750.0);
			vacante1.setEstatus("Aprobada");
			vacante1.setDestacado(1);
			vacante1.setImagen("empresa3.png");
			
			// Se crea segunda oferta de trabajo
			Vacante vacante2 = new Vacante();
			vacante2.setId(2);
			vacante2.setNombre("Ingeniero civil");
			vacante2.setDescripcion("Se requiere ing.Civil para diseñar puente peatonal");
			vacante2.setFecha(sdf.parse("10-02-2020"));
			vacante2.setSalario(15950.0);
			vacante2.setEstatus("Creada");
			vacante2.setDestacado(0);
			vacante2.setImagen("empresa2.png");
			
			
			// Se crea tercera oferta de trabajo
			Vacante vacante3 = new Vacante();
			vacante3.setId(3);
			vacante3.setNombre("Contador público");
			vacante3.setDescripcion("Importante empresa requiere contador con 5 años de experiencia titulado");
			vacante3.setFecha(sdf.parse("20-02-2020"));
			vacante3.setSalario(9900.0);
			vacante3.setEstatus("Aprobada");
			vacante3.setDestacado(0);
			vacante3.setImagen("no-image.png");
			
			// Se crea cuarta oferta de trabajo
			Vacante vacante4 = new Vacante();
			vacante4.setId(4);
			vacante4.setNombre("Ingeniero Eléctrico");
			vacante4.setDescripcion("Empresa requiere Ing Electrico para mantencion de la instalación electrica");
			vacante4.setFecha(sdf.parse("02-03-2020"));
			vacante4.setSalario(12500.0);
			vacante4.setEstatus("Rechazada");
			vacante4.setDestacado(1);
			vacante4.setImagen("empresa1.png");
			
			
			
			lista.add(vacante1);
			lista.add(vacante2);
			lista.add(vacante3);
			lista.add(vacante4);
					
		}
		catch (ParseException e){
			System.out.println ("Error: "+ e.getMessage());			
		}						
	}
	
	public List<Vacante> buscarTodas() {
		
		return lista;
	}

	@Override
	public Vacante buscarPorId(Integer idVacante) {		
		for(Vacante v : lista) {			
			if(v.getId() == idVacante) {
				return v;
			}
			
		}
		
		return null;
	}

	@Override
	public void guardar(Vacante vacante) {
		lista.add(vacante);
		
	}

	@Override
	public List<Vacante> buscarDestacadas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(Integer idVacante) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Vacante> buscarByExample(Example<Vacante> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Vacante> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

}
