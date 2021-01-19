package net.mesa.service;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.mesa.model.Vacante;

public interface VacantesService {

	List<Vacante> buscarTodas();
	Vacante buscarPorId(Integer idVacante);
	void guardar(Vacante vacante);
	List<Vacante> buscarDestacada();
	void eliminar(Integer idVacante);
	List<Vacante> buscarByExample(Example<Vacante> example);
	Page<Vacante> buscarTodas(Pageable page);
}
