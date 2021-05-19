package com.bcopstein.negocio.servicos;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.bcopstein.negocio.entidades.ItemEstoque;
import com.bcopstein.negocio.entidades.Venda;
import com.bcopstein.negocio.repositorios.IVendaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ServicoVendas
 */

@Service
public class ServicoVendas {

    private IVendaRepository vendaRepository;

    @Autowired
    public ServicoVendas(IVendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }

    //TODO 
    public boolean confirmaVenda(List<ItemEstoque> itens) {
        return true;
    }

    //TODO
    public List<Venda> vendasEfetuadas() {
        return null;
    }

    //TODO
    public Integer[] calculaSubtotal(List<ItemEstoque> itens) {
        return null;
    }
}