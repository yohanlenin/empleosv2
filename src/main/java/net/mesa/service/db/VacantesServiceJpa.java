package net.mesa.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import net.mesa.model.Vacante;
import net.mesa.repository.VacantesRepository;
import net.mesa.service.VacantesService;

@Primary
@Service
public class VacantesServiceJpa implements VacantesService {
	
	@Autowired
	VacantesRepository repoVacantes;
	@Override
	public List<Vacante> buscarTodas() {
		
		return repoVacantes.findAll();
	}

	@Override
	public Vacante buscarPorId(Integer idVacante) {
		Optional<Vacante> optional = repoVacantes.findById(idVacante);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public void guardar(Vacante vacante) {
		repoVacantes.save(vacante);

	}

}
