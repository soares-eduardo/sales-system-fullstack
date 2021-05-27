package com.bcopstein.aplicacao.strategy;

import com.bcopstein.negocio.repositorios.ICalculoTaxaPaisStrategyRepository;

public class CalculoTaxaPaisDois implements ICalculoTaxaPaisStrategyRepository {

    private double taxa = 0.15;

    public Integer calcularTaxa(int subtotal) {
        if (subtotal > 8000) {
            taxa = 0.2;
            return (int) (subtotal * taxa);
        }
        return (int) (subtotal * taxa);
    }
}
