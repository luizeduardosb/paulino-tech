package com.paulino.backend.service;
 
 import java.util.Date;
 import java.util.List;
 
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;
 
 import com.paulino.backend.entity.Cidade;
 import com.paulino.backend.repository.CidadeRepository;
 
 @Service
 public class CidadeService {
 
     @Autowired
     private CidadeRepository cidadeRepository;
 
     public List<Cidade> buscarTodos() {
         return cidadeRepository.findAll();
     }
 
     public Cidade salvar(Cidade cidade) {
         cidade.setDataCriacao(new Date());
         Cidade cidadeNova = cidadeRepository.saveAndFlush(cidade);
         return cidadeNova;
     }
 
     public Cidade editar(Cidade cidade) {
         cidade.setDataAtualizacao(new Date());
         return cidadeRepository.saveAndFlush(cidade);
     }
 
     public void excluir(Long id) {
         Cidade cidade = cidadeRepository.findById(id).get();
         cidadeRepository.delete(cidade);
     }
 }