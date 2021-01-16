package net.mesa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.mesa.model.Usuario;
@Repository
public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {

}
