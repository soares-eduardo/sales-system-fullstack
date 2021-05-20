package com.bcopstein.negocio.servicos;

import java.util.ArrayList;
import java.util.List;

import com.bcopstein.negocio.entidades.ItemEstoque;
import com.bcopstein.negocio.entidades.ItemVenda;
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
    private ServicoEstoque servicoEstoque;

    @Autowired
    public ServicoVendas(IVendaRepository vendaRepository, ServicoEstoque servicoEstoque) {
        this.vendaRepository = vendaRepository;
        this.servicoEstoque = servicoEstoque;
    }

    public boolean confirmaVenda(List<ItemEstoque> itens) {

        servicoEstoque.darBaixaEstoque(itens);
        int imposto = servicoEstoque.calculaSubtotal(itens)[1];

        List<ItemVenda> itemVendas = new ArrayList<ItemVenda>();

        Venda venda = new Venda();

        for (ItemEstoque item : itens) {
            ItemEstoque itemEstoque = servicoEstoque.buscarItemEstoqueByCodigo(item.getCodigo());
            ItemVenda itemVenda = new ItemVenda(itemEstoque.getQuantidade(),
                    itemEstoque.getProduto().getPrecoUnitario(), imposto, itemEstoque.getProduto(), venda);
            itemVendas.add(itemVenda);
        }

        venda.setItemVenda(itemVendas);
        vendaRepository.insertVendas(List.of(venda));

        return true;

    }

    public List<Venda> vendasEfetuadas() {
        return vendaRepository.getAllVendas();
    }
}