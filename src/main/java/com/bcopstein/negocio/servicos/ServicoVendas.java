package com.bcopstein.negocio.servicos;

import java.util.ArrayList;
import java.util.List;

import com.bcopstein.negocio.entidades.ItemEstoque;
import com.bcopstein.negocio.entidades.ItemVenda;
import com.bcopstein.negocio.entidades.Venda;
import com.bcopstein.negocio.repositorios.IEstoqueRepository;
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
    // TODO Factory para limitar quantidade de produtos que compoem a venda e o valor total
    public boolean confirmaVenda(List<ItemEstoque> itens) {

        int imposto = servicoEstoque.calculaSubtotal(itens)[1];

        // TODO Usar o calculaSubtotal para fazer o factory de valor total 

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

        servicoEstoque.darBaixaEstoque(itens);

        return true;

    }

    public List<Venda> vendasEfetuadas() {
        return vendaRepository.getAllVendas();
    }
}