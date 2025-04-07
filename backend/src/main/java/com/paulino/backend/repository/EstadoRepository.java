package com.paulino.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paulino.backend.entity.Estado;
public interface EstadoRepository extends JpaRepository<Estado, Long> {
    
}
