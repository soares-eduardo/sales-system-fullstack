package com.bcopstein.aplicacao.strategy;

import com.bcopstein.negocio.strategy.ICalculoTaxaPais;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class CalculoTaxaPaisUm implements ICalculoTaxaPais{

    public double calcularTaxa(int subtotal) {
        return subtotal * (20 / 100);
    }
}
