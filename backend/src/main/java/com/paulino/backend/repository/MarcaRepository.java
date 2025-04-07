package com.paulino.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paulino.backend.entity.Marca;
public interface MarcaRepository extends JpaRepository<Marca, Long> {
    
}
