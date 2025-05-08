package com.paulino.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paulino.backend.entity.Estado;
import com.paulino.backend.service.EstadoService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/estado")
public class EstadoController {
    
    @Autowired
    private EstadoService estadoService;

    @GetMapping("/")
    @CrossOrigin("http://localhost:3000")
    public List<Estado> buscarTodos(){
        return estadoService.buscarTodos();
    }

    @PostMapping("/")
    @CrossOrigin("http://localhost:3000")
    public Estado salvar(@RequestBody Estado estado) {
        return estadoService.salvar(estado);
    }

    @PutMapping("/{id}")
    @CrossOrigin("http://localhost:3000")
    public Estado editar(@RequestBody Estado estado) {
        return estadoService.editar(estado);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin("http://localhost:3000")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        estadoService.excluir(id);
        return ResponseEntity.ok().build();
    }




}
