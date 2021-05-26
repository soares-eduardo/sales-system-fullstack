package com.bcopstein.aplicacao.strategy;

import com.bcopstein.negocio.repositorios.ICalculoTaxaPaisStrategyRepository;

public class CalculoTaxaPaisUm implements ICalculoTaxaPaisStrategyRepository {

    private final double TAXA = 0.2;

    public Integer calcularTaxa(int subtotal) {
        return (int) (subtotal * TAXA);
    }
}
