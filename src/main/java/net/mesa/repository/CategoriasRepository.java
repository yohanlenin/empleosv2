package net.mesa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.mesa.model.Categoria;
@Repository
public interface CategoriasRepository extends JpaRepository<Categoria, Integer> {

}
