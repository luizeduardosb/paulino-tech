package com.paulino.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paulino.backend.entity.Pessoa;
import com.paulino.backend.repository.PessoaRepository;

@Service
  public class PessoaService {
  
      @Autowired
      private PessoaRepository pessoaRepository;

      public List<Pessoa> buscarTodos() {
        return pessoaRepository.findAll();
        
      }
  
      public Pessoa salvar(Pessoa pessoa) {
          pessoa.setDataCriacao(new Date());
          Pessoa pessoaNova = pessoaRepository.saveAndFlush(pessoa);
          return pessoaNova;
      }
  
      public Pessoa editar(Pessoa pessoa) {
          pessoa.setDataAtualizacao(new Date());
          return pessoaRepository.saveAndFlush(pessoa);
      }
  
      public void excluir(Long id) {
          Pessoa pessoa = pessoaRepository.findById(id).get();
          pessoaRepository.delete(pessoa);
      }
  }
