package com.bcopstein.aplicacao.usecase;

import java.util.List;

import com.bcopstein.negocio.entidades.Produto;
import com.bcopstein.negocio.servicos.ServicoProduto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ListaProdutosUC {
    
    private ServicoProduto servicoProduto;

    @Autowired
    public ListaProdutosUC(ServicoProduto servicoProduto) {
        this.servicoProduto = servicoProduto;
    }

    public List<Produto> run() {
        return servicoProduto.listaProdutos();
    }
}
