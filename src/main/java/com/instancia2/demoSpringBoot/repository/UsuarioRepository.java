package com.instancia2.demoSpringBoot.repository;

import com.instancia2.demoSpringBoot.dto.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioRepository extends JpaRepository<Usuarios, Integer> {
}
