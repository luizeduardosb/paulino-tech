package com.paulino.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paulino.backend.entity.Produto;
import com.paulino.backend.repository.ProdutoRepository;

@Service
  public class ProdutoService {
  
      @Autowired
      private ProdutoRepository produtoRepository;

      public List<Produto> buscarTodos() {
        return produtoRepository.findAll(); 
      }
  
      public Produto salvar(Produto produto) {
          produto.setDataCriacao(new Date());
          Produto produtoNovo = produtoRepository.saveAndFlush(produto)
          return produtoNovo;
      }
  
      public Produto editar(Produto produto) {
          produto.setDataAtualizacao(new Date());
          return produtoRepository.saveAndFlush(produto);
      }
  
      public void excluir(Long id) {
          Produto produto = produtoRepository.findById(id).get();
          produtoRepository.delete(produto);
      }
  }