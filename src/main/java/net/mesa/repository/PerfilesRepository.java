package net.mesa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.mesa.model.Perfil;
@Repository
public interface PerfilesRepository extends JpaRepository<Perfil, Integer> {

}
