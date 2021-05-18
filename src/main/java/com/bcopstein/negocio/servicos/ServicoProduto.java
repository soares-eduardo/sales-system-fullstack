package com.bcopstein.negocio.servicos;

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
}
