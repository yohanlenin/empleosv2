package net.mesa.service;

import java.util.List;

import net.mesa.model.Usuario;

public interface IUsuariosService {

	void guardar(Usuario usuario);

	void eliminar(Integer idUsuario);
	
	List<Usuario> buscarTodos();
}


