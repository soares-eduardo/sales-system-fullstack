package com.bcopstein.aplicacao.strategy;

import com.bcopstein.negocio.strategy.ICalculoTaxaPais;

public class CalculoTaxaPaisUm implements ICalculoTaxaPais {

    private final double TAXA = 0.2;

    public Integer calcularTaxa(int subtotal) {
        return (int) (subtotal * TAXA);
    }
}
