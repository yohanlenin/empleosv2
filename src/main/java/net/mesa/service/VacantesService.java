package net.mesa.service;

import java.util.List;

import net.mesa.model.Vacante;

public interface VacantesService {

	List<Vacante> buscarTodas();
	Vacante buscarPorId(Integer idVacante);
	void guardar(Vacante vacante);
}
