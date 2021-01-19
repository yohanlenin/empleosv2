package net.mesa.service;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.mesa.model.Vacante;


@Service
public class VacanteServiceImpl implements VacantesService {
	
	private List<Vacante> listaVacante = null;

	public VacanteServiceImpl() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		listaVacante = new LinkedList<Vacante>();
		
		try {
			
			Vacante vacante1 = new Vacante();
			vacante1.setId(1);
			vacante1.setNombre("Ingeniero de Informatica");
			vacante1.setDescripcion("Controlar los locos");
			vacante1.setFecha(sdf.parse("08-07-2020"));
			vacante1.setSalario(8799.0);
			vacante1.setDestacado(1);
			vacante1.setEstatus("creada");
			vacante1.setImagen("omega-3-proscience.png");
			
			Vacante vacante2 = new Vacante();
			vacante2.setId(2);
			vacante2.setNombre("Ingeniero de software");
			vacante2.setDescripcion("Controlar App");
			vacante2.setFecha(sdf.parse("08-07-2010"));
			vacante2.setSalario(8799.0);
			vacante2.setDestacado(0);
			vacante2.setEstatus("aprovada");
			vacante2.setImagen("smart-gainer-13lb.png");
			
			Vacante vacante3 = new Vacante();
			vacante3.setId(3);
			vacante3.setNombre("Ingeniero industrial");
			vacante3.setDescripcion("Controlar los locos");
			vacante3.setFecha(sdf.parse("08-07-2007"));
			vacante3.setSalario(8799.0);
			vacante3.setDestacado(0);
			vacante3.setEstatus("Eliminada");
			vacante3.setImagen("the-one-proscience-orange.png");
			
			Vacante vacante4 = new Vacante();
			vacante4.setId(4);
			vacante4.setNombre("Ingeniero de de la calle");
			vacante4.setDescripcion("Controlar los locos");
			vacante4.setFecha(sdf.parse("08-07-2020"));
			vacante4.setSalario(8799.0);
			vacante4.setDestacado(1);
			vacante4.setEstatus("creada");
			
			listaVacante.add(vacante1);
			listaVacante.add(vacante2);
			listaVacante.add(vacante3);
			listaVacante.add(vacante4);
			
		} catch (java.text.ParseException e) {
			System.out.println("Error ." + e.getMessage());
		}
		
	}

	public List<Vacante> buscarTodas() {
		return listaVacante;
	}


	public Vacante buscarPorId(Integer id) {

		for(Vacante v : listaVacante) {
			if(v.getId() == id) {
				return v;
			}
		}
		
		return null;
	}

	@Override
	public void guardar(Vacante vacante) {
		listaVacante.add(vacante);
		
	}

	@Override
	public List<Vacante> buscarDestacada() {
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
