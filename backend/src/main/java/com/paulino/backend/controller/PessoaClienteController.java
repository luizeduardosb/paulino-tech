package com.paulino.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paulino.backend.dto.PessoaClienteRequestDTO;
import com.paulino.backend.entity.Pessoa;
import com.paulino.backend.service.PessoaClienteService;

@RestController
@RequestMapping("/api/cliente")
public class PessoaClienteController {

    @Autowired
    private PessoaClienteService pessoaClienteService;

    @PostMapping("/")
    public Pessoa salvar(@RequestBody PessoaClienteRequestDTO pessoaClienteRequestDTO) {
        return pessoaClienteService.salvar(pessoaClienteRequestDTO);
    }
}
