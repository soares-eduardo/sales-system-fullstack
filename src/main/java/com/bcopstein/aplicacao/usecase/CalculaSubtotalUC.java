package com.bcopstein.aplicacao.usecase;

import java.util.List;

import com.bcopstein.negocio.entidades.ItemEstoque;
import com.bcopstein.negocio.servicos.ServicoVendas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CalculaSubtotalUC {
    
    private ServicoVendas servicoVendas;

    @Autowired
    public CalculaSubtotalUC(ServicoVendas servicoVendas) {
        this.servicoVendas = servicoVendas;
    }

    public Integer[] run(List<ItemEstoque> itens) {
        return servicoVendas.calculaSubtotal(itens);
    }
}
