package net.mesa.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import net.mesa.model.Categoria;
import net.mesa.repository.CategoriasRepository;
import net.mesa.service.ICategoriasService;

@Primary
@Service
public class CategoriasServiceJpa implements ICategoriasService {
	
	@Autowired
	CategoriasRepository repoCategoria;

	@Override
	public void guardar(Categoria categoria) {
		repoCategoria.save(categoria);

	}

	@Override
	public List<Categoria> buscarTodas() {
		return repoCategoria.findAll();
		
	}

	@Override
	public Categoria buscarPorId(Integer idCategoria) {
		Optional<Categoria> optional = repoCategoria.findById(idCategoria);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public void eliminar(Integer idCategoria) {
		repoCategoria.deleteById(idCategoria);
		
	}

	

}
