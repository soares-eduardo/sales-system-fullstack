package com.bcopstein.aplicacao.strategy;

import com.bcopstein.negocio.strategy.ICalculoTaxaPais;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class CalculoTaxaPaisUm implements ICalculoTaxaPais {

    private final double TAXA = 0.2;

    public Integer calcularTaxa(int subtotal) {
        return (int) (subtotal * TAXA);
    }
}
