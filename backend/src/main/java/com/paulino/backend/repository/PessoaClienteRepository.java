package com.paulino.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paulino.backend.entity.Pessoa;

public interface PessoaClienteRepository extends JpaRepository<Pessoa, Long> {

}
