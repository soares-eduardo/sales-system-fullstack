package com.bcopstein.aplicacao.usecase;

import com.bcopstein.negocio.servicos.ServicoEstoque;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PodeVenderUC {

    private ServicoEstoque servicoEstoque;

    @Autowired
    public PodeVenderUC(ServicoEstoque servicoEstoque) {
        this.servicoEstoque = servicoEstoque;
    }

    public boolean run(Long codigo, Integer quantidade) {
        return servicoEstoque.podeVender(codigo, quantidade);
    }
}