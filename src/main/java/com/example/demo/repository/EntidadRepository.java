package com.example.demo.repository;

import com.example.demo.models.Entidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntidadRepository extends JpaRepository<Entidad,Long> {
}
