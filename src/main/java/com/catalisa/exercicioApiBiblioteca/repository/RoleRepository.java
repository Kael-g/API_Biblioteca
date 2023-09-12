package com.catalisa.exercicioApiBiblioteca.repository;

import com.catalisa.exercicioApiBiblioteca.model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleModel, Long> {
}
