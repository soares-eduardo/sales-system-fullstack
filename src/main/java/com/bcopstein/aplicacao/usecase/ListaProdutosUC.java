package com.bcopstein.aplicacao.usecase;

import java.util.List;

import com.bcopstein.negocio.entidades.ItemEstoque;
import com.bcopstein.negocio.entidades.Produto;
import com.bcopstein.negocio.servicos.ServicoEstoque;
import com.bcopstein.negocio.servicos.ServicoProduto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ListaProdutosUC {
    
    private ServicoEstoque servicoEstoque;

    @Autowired
    public ListaProdutosUC(ServicoEstoque servicoEstoque) {
        this.servicoEstoque = servicoEstoque;
    }

    public List<ItemEstoque> run() {
        return servicoEstoque.listaProdutos();
    }
}
