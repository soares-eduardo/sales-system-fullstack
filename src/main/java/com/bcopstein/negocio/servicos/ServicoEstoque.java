package com.bcopstein.negocio.servicos;

import com.bcopstein.negocio.repositorios.IEstoqueRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoEstoque {
    
    private IEstoqueRepository estoqueRepository;

    @Autowired
    public ServicoEstoque(IEstoqueRepository estoqueRepository) {
        this.estoqueRepository = estoqueRepository;
    }
}
