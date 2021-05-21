package com.bcopstein.negocio.servicos;

import java.util.List;

import com.bcopstein.negocio.entidades.ItemEstoque;
import com.bcopstein.negocio.repositorios.IEstoqueRepository;
import com.bcopstein.negocio.strategy.ICalculoTaxaPais;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoEstoque {

    private IEstoqueRepository estoqueRepository;
    private ICalculoTaxaPais calculoTaxaPaisRepository;

    @Autowired
    public ServicoEstoque(IEstoqueRepository estoqueRepository, ICalculoTaxaPais calculoTaxaPaisRepository) {
        this.estoqueRepository = estoqueRepository;
        this.calculoTaxaPaisRepository = calculoTaxaPaisRepository;
    }

    public int calcularTaxa(int subtotal) {
        return calculoTaxaPaisRepository.calcularTaxa(subtotal);
    }
    
    public boolean podeVender(Long codigo, Integer quantidade) {

        ItemEstoque item = estoqueRepository.getItemEstoqueById(codigo).orElseThrow(
                () -> new IllegalStateException("Produto de codigo " + codigo + " não foi encontrado no estoque."));

        if (item.getQuantidade() >= quantidade) {
            return true;
        }

        return false;
    }

    public List<ItemEstoque> listaItemEstoques() {
        return estoqueRepository.getAllItemEstoque();
    }

    public ItemEstoque buscarItemEstoqueByCodigo(Long codigo) {
        
        ItemEstoque itemEstoque = estoqueRepository.getItemEstoqueById(codigo)
                .orElseThrow(() -> new IllegalStateException(
                        "Produto de codigo " + codigo + " não foi encontrado no estoque."));

        return itemEstoque;
    }

    public Integer[] calculaSubtotal(List<ItemEstoque> itens) {

        //TODO Strategy
        final Integer[] valores = new Integer[3];

        Integer imposto = 0;
        int subtotal = 0;

        for (ItemEstoque item : itens) {

            ItemEstoque itemEstoque = buscarItemEstoqueByCodigo(item.getCodigo());

            subtotal += itemEstoque.getProduto().getPrecoUnitario() * item.getQuantidade();
        }

        imposto = calcularTaxa(subtotal);

        valores[0] = subtotal;
        valores[1] = imposto;
        valores[2] = subtotal + imposto;

        return valores;
    }

    public void darBaixaEstoque(List<ItemEstoque> itens) {

        for (ItemEstoque item : itens) {

            ItemEstoque itemEstoque = buscarItemEstoqueByCodigo(item.getCodigo());

            itemEstoque.setQuantidade(itemEstoque.getQuantidade() - item.getQuantidade());

        }
    }
}
