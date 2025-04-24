package com.paulino.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paulino.backend.service.EmailService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/teste-email")
public class EmailTesteController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/")
    public String testarEnvio() {
        return emailService.enviarEmailTexto("luizeduardo00736@gmail.com", "Teste", "Testando envio de email.");
    }
}

