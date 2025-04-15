package com.paulino.backend.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.paulino.backend.entity.Produto;
import com.paulino.backend.entity.ProdutoImagem;
import com.paulino.backend.repository.ProdutoImagemRepository;
import com.paulino.backend.repository.ProdutoRepository;

@Service
public class ProdutoImagemService {

    @Autowired
    private ProdutoImagemRepository produtoImagemRepository;
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ProdutoImagem> buscarTodos() {
        return produtoImagemRepository.findAll();
    }

    public ProdutoImagem salvar(Long idProduto, MultipartFile file) {
        Produto produto = produtoRepository.findById(idProduto).get();
        ProdutoImagem produtoImagemNovo = new ProdutoImagem();

        try {
            if (!file.isEmpty()) {
                byte[] bytes = file.getBytes();
                String nomeImagem = String.valueOf(produto.getId()) + file.getOriginalFilename();

                Path caminho = Paths.get("C:/Users/dudu0/Documents/Loja Virtual/paulino-tech/produtoImagens/" + nomeImagem);               
                Files.write(caminho, bytes);
                produtoImagemNovo.setNome(nomeImagem);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        produtoImagemNovo.setProduto(produto);
        produtoImagemNovo.setDataCriacao(new Date());
        produtoImagemNovo = produtoImagemRepository.saveAndFlush(produtoImagemNovo);
        return produtoImagemNovo;
    }

    public ProdutoImagem editar(ProdutoImagem produtoImagem) {
        produtoImagem.setDataAtualizacao(new Date());
        return produtoImagemRepository.saveAndFlush(produtoImagem);
    }

    public void excluir(Long id) {
        ProdutoImagem produtoImagem = produtoImagemRepository.findById(id).get();
        produtoImagemRepository.delete(produtoImagem);
    }
}