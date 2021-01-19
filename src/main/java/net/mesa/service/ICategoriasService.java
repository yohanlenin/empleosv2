package net.mesa.service;


import java.util.List;

import net.mesa.model.Categoria;

public interface ICategoriasService {
	void guardar(Categoria categoria);
	List<Categoria> buscarTodas();
	Categoria buscarPorId(Integer idCategoria);	
	// Ejercicio: Implementar método
		void eliminar(Integer idCategoria);
	
}

