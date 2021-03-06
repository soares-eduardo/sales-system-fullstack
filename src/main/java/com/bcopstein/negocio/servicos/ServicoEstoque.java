package com.bcopstein.negocio.servicos;

import java.util.List;

import com.bcopstein.negocio.entidades.ItemEstoque;
import com.bcopstein.negocio.factory.LimiteVendaFactory;
import com.bcopstein.negocio.repositorios.ICalculoTaxaPaisStrategyRepository;
import com.bcopstein.negocio.repositorios.IEstoqueRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServicoEstoque {

    private IEstoqueRepository estoqueRepository;
    private ICalculoTaxaPaisStrategyRepository calculoTaxaPaisRepository;

    @Autowired
    public ServicoEstoque(IEstoqueRepository estoqueRepository,
            ICalculoTaxaPaisStrategyRepository calculoTaxaPaisRepository, LimiteVendaFactory limiteVendaFactory) {
        this.estoqueRepository = estoqueRepository;
        this.calculoTaxaPaisRepository = calculoTaxaPaisRepository;
    }

    public int calcularTaxa(int subtotal) {
        return calculoTaxaPaisRepository.calcularTaxa(subtotal);
    }

    public boolean podeVender(Long codigo, Integer quantidade) {

        ItemEstoque item = buscarItemEstoqueByCodigo(codigo);

        if (item.getQuantidade() >= quantidade) {
            return true;
        }

        return false;
    }

    public List<ItemEstoque> listaItemEstoques() {
        return estoqueRepository.getAllItemEstoque();
    }

    public ItemEstoque buscarItemEstoqueByCodigo(Long codigo) {

        ItemEstoque itemEstoque = estoqueRepository.getItemEstoqueById(codigo).orElseThrow(
                () -> new IllegalStateException("Produto de codigo " + codigo + " não foi encontrado no estoque."));

        return itemEstoque;
    }

    public Integer[] calculaSubtotal(List<ItemEstoque> itens) {

        final Integer[] valores = new Integer[3];

        int subtotal = 0;

        for (ItemEstoque item : itens) {

            ItemEstoque itemEstoque = buscarItemEstoqueByCodigo(item.getCodigo());

            subtotal += itemEstoque.getProduto().getPrecoUnitario() * item.getQuantidade();
        }

        Integer imposto = calcularTaxa(subtotal);

        valores[0] = subtotal;
        valores[1] = imposto;
        valores[2] = subtotal + imposto;

        return valores;
    }

    @Transactional
    public void darBaixaEstoque(List<ItemEstoque> itens) {
        for (ItemEstoque item : itens) {

            ItemEstoque itemEstoque = buscarItemEstoqueByCodigo(item.getCodigo());

            itemEstoque.setQuantidade(itemEstoque.getQuantidade() - item.getQuantidade());
        }
    }
}
