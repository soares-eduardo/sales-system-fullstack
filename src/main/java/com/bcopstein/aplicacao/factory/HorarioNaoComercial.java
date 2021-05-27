package com.bcopstein.aplicacao.factory;

import com.bcopstein.negocio.factory.LimiteVenda;
import com.bcopstein.negocio.entidades.ItemEstoque;
import java.util.List;

public class HorarioNaoComercial implements LimiteVenda {

    private final double VALOR = 5000;
    private final int QTD_ITENS = 3;
    private final int QTD_PRODUTOS = 5;

    public double calcularValorTotal(List<ItemEstoque> itens) {

        double valorTotal = 0;

        for (ItemEstoque item : itens) {
            valorTotal += (item.getProduto().getPrecoUnitario() * item.getQuantidade());
        }

        return valorTotal;
    }

    public boolean verificarQuantidadePorItem(List<ItemEstoque> itens) {

        for (ItemEstoque item : itens) {
            if (item.getQuantidade() > QTD_PRODUTOS) {
                return true;
            }
        }                  
        return false;
    }

    @Override
    public boolean temRestricao(List<ItemEstoque> itens) {
    
        double valorTotal = calcularValorTotal(itens);

        if (verificarQuantidadePorItem(itens) || itens.size() > QTD_ITENS || valorTotal > VALOR) {
            return true;
        }
        return false;
    }
}
