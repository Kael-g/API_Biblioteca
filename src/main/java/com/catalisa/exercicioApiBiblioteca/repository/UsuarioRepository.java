package com.catalisa.exercicioApiBiblioteca.repository;

import com.catalisa.exercicioApiBiblioteca.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
    Optional<UsuarioModel> findByUsername(String username);
}
