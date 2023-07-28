package com.catalisa.exercicioApiBiblioteca.repository;

import com.catalisa.exercicioApiBiblioteca.model.LivrosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivrosRepository extends JpaRepository<LivrosModel, Long> {
}
