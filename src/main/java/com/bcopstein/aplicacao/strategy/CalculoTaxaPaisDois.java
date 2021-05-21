package com.bcopstein.aplicacao.strategy;

import com.bcopstein.negocio.strategy.ICalculoTaxaPais;

import org.springframework.stereotype.Component;

@Component
public class CalculoTaxaPaisDois implements ICalculoTaxaPais{
    
    public double calcularTaxa(int subtotal) {
        if (subtotal > 8000){
            return subtotal * (20 / 100);
        }
        return subtotal * (15 / 100);
    }
}
