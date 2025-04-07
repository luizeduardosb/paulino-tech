package com.paulino.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paulino.backend.entity.Categoria;
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    
}
