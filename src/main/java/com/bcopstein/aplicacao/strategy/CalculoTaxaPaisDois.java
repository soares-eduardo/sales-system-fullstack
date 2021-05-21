package com.bcopstein.aplicacao.strategy;

import com.bcopstein.negocio.strategy.ICalculoTaxaPais;

import org.springframework.stereotype.Component;

@Component
public class CalculoTaxaPaisDois implements ICalculoTaxaPais{
    
    private double taxa = 0.15;

    public Integer calcularTaxa(int subtotal) {
        if (subtotal > 8000){
            taxa = 0.2;
            return (int) (subtotal * taxa);
        }
        return (int) (subtotal * taxa);
    }
}
