package com.bcopstein.aplicacao.usecase;

import java.util.List;

import com.bcopstein.negocio.entidades.ItemEstoque;
import com.bcopstein.negocio.servicos.ServicoEstoque;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CalculaSubtotalUC {
    
    private ServicoEstoque servicoEstoque;

    @Autowired
    public CalculaSubtotalUC(ServicoEstoque servicoEstoque) {
        this.servicoEstoque = servicoEstoque;
    }

    public Integer[] run(List<ItemEstoque> itens) {
        return servicoEstoque.calculaSubtotal(itens);
    }
}
