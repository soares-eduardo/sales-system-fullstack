package com.bcopstein.negocio.servicos;

import java.util.ArrayList;
import java.util.List;

import com.bcopstein.negocio.entidades.ItemEstoque;
import com.bcopstein.negocio.entidades.ItemVenda;
import com.bcopstein.negocio.entidades.Produto;
import com.bcopstein.negocio.entidades.Venda;
import com.bcopstein.negocio.factory.LimiteVendaFactory;
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
    private LimiteVendaFactory limiteVendaFactory;

    @Autowired
    public ServicoVendas(IVendaRepository vendaRepository, ServicoEstoque servicoEstoque,
            LimiteVendaFactory limiteVendaFactory) {
        this.vendaRepository = vendaRepository;
        this.servicoEstoque = servicoEstoque;
        this.limiteVendaFactory = limiteVendaFactory;
    }

    public boolean confirmaVenda(List<ItemEstoque> itens) {

        List<ItemEstoque> itensSolicitados = new ArrayList<ItemEstoque>();

        for (ItemEstoque item : itens) {
            
            Produto produto = servicoEstoque.buscarItemEstoqueByCodigo(item.getCodigo()).getProduto();
            ItemEstoque itemEstoque = new ItemEstoque(item.getCodigo(), item.getQuantidade(), produto);
            itensSolicitados.add(itemEstoque);
            
        }

        if (limiteVendaFactory.getInstance().temRestricao(itensSolicitados)) {
            return false;
        }

        int imposto = servicoEstoque.calculaSubtotal(itens)[1];

        List<ItemVenda> itemVendas = new ArrayList<ItemVenda>();

        Venda venda = new Venda();

        for (ItemEstoque item : itens) {
            ItemEstoque itemEstoque = servicoEstoque.buscarItemEstoqueByCodigo(item.getCodigo());

            ItemVenda itemVenda = new ItemVenda(item.getQuantidade(),
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