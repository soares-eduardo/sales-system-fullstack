package com.bcopstein.negocio.servicos;

import java.util.List;
import java.util.Optional;

import com.bcopstein.negocio.entidades.ItemEstoque;
import com.bcopstein.negocio.entidades.Produto;
import com.bcopstein.negocio.repositorios.IEstoqueRepository;
import com.bcopstein.negocio.repositorios.IProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoProduto {
    
    private IProdutoRepository produtoRepository;

    @Autowired
    public ServicoProduto(IProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> listaProdutos() {
        return produtoRepository.getAllProdutos();
    }

}