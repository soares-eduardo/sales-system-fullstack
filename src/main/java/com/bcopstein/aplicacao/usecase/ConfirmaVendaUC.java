package com.bcopstein.aplicacao.usecase;

import java.util.List;

import com.bcopstein.negocio.entidades.ItemEstoque;
import com.bcopstein.negocio.servicos.ServicoVendas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConfirmaVendaUC {
    
    private ServicoVendas servicoVendas;

    @Autowired
    public ConfirmaVendaUC(ServicoVendas servicoVendas) {
        this.servicoVendas = servicoVendas;
    }

    public boolean run(List<ItemEstoque> itens) {
       return servicoVendas.confirmaVenda(itens); 
    }
}
