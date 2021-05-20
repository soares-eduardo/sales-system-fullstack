package com.bcopstein.negocio.repositorios;

import java.util.List;
import java.util.Optional;

import com.bcopstein.negocio.entidades.Venda;

public interface IVendaRepository {
    
    List<Venda> getAllVendas();
    Optional<Venda> getVendaById(Long id);
    void insertVendas(List<Venda> vendas);
}
