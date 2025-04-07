package com.paulino.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paulino.backend.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
}
