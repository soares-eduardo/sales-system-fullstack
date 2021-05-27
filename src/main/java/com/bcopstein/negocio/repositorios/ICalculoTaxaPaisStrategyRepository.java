package com.bcopstein.negocio.repositorios;

/**
 * ICalculoTaxaPais
 */
public interface ICalculoTaxaPaisStrategyRepository {

    Integer calcularTaxa(int subtotal);

}