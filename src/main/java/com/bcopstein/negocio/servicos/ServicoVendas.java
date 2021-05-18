package com.bcopstein.negocio.servicos;


import com.bcopstein.negocio.repositorios.IVendaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ServicoVendas
 */

@Service
public class ServicoVendas {

    private IVendaRepository vendaRepository;
    //private IEstoqueRepository estoqueRepository;

    @Autowired
    public ServicoVendas(IVendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
        //this.estoqueRepository = estoqueRepository; 
    }

}