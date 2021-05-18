package com.bcopstein.negocio.servicos;


import java.util.List;
import java.util.Optional;

import com.bcopstein.negocio.entidades.Venda;
import com.bcopstein.negocio.repositorios.IVendaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ServicoVendas
 */

@Service
public class ServicoVendas {

    private IVendaRepository vendaRepository;

    @Autowired
    public ServicoVendas(IVendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }

    public List<Venda> getAllVendas() {
        return vendaRepository.getAllVendas();
    }

    public Optional<Venda> getVendaById(Long id) {
        return vendaRepository.getVendaById(id);
    }
}