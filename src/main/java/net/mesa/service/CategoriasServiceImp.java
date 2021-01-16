package net.mesa.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import net.mesa.model.Categoria;

@Service
public class CategoriasServiceImp implements ICategoriasService {

	private List<Categoria> listaCategorias = null;
	
	public CategoriasServiceImp() {
		listaCategorias = new LinkedList<Categoria>();

			
			Categoria categoria1 = new Categoria();
			categoria1.setId(1);
			categoria1.setNombre("Ventas");
			categoria1.setDescripcion("detalle de las ventas");
			
			Categoria categoria2 = new Categoria();
			categoria2.setId(2);
			categoria2.setNombre("marketin");
			categoria2.setDescripcion("detalle de las marketin");
			
			Categoria categoria3 = new Categoria();
			categoria3.setId(3);
			categoria3.setNombre("comunicaciones");
			categoria3.setDescripcion("detalle de las comunicaciones");
			
			Categoria categoria4 = new Categoria();
			categoria4.setId(4);
			categoria4.setNombre("Arquitectura");
			categoria4.setDescripcion("detalle de las arquitectura");
			
			Categoria categoria5 = new Categoria();
			categoria5.setId(5);
			categoria5.setNombre("educación");
			categoria5.setDescripcion("detalle de Educación");
			
			listaCategorias.add(categoria1);
			listaCategorias.add(categoria2);
			listaCategorias.add(categoria3);
			listaCategorias.add(categoria4);
			listaCategorias.add(categoria5);
	}			
	
	@Override
	public void guardar(Categoria categoria) {
		
		listaCategorias.add(categoria);
	}

	@Override
	public List<Categoria> buscarTodas() {
		// TODO Auto-generated method stub
		return listaCategorias;
	}

	@Override
	public Categoria buscarPorId(Integer idCategoria) {
		for(Categoria c : listaCategorias) {
			if(c.getId() == idCategoria)
				return c;
		}
		return null;
	}

}
