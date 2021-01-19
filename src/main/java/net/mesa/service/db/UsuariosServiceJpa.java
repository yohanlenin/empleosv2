package net.mesa.service.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.mesa.model.Usuario;
import net.mesa.repository.UsuariosRepository;
import net.mesa.service.IUsuariosService;

@Service
public class UsuariosServiceJpa implements IUsuariosService {

	@Autowired
	UsuariosRepository repoUsuario;
	
	@Override
	public void guardar(Usuario usuario) {
		repoUsuario.save(usuario);

	}

	@Override
	public void eliminar(Integer idUsuario) {
		repoUsuario.deleteById(idUsuario);

	}

	@Override
	public List<Usuario> buscarTodos() {
		
		return repoUsuario.findAll();
	}

}
