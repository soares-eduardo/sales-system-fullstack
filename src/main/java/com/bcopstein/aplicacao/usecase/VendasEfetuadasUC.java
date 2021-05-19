package com.bcopstein.aplicacao.usecase;

import java.util.List;

import com.bcopstein.negocio.entidades.Venda;
import com.bcopstein.negocio.servicos.ServicoVendas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VendasEfetuadasUC {
    
    private ServicoVendas servicoVendas;

    @Autowired
    public VendasEfetuadasUC(ServicoVendas servicoVendas) {
        this.servicoVendas = servicoVendas;
    }

    public List<Venda> run() {
        return servicoVendas.vendasEfetuadas();
    }
}
