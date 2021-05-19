package com.bcopstein.negocio.servicos;

import java.util.List;
import java.util.Optional;

import com.bcopstein.negocio.entidades.ItemEstoque;
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

    //TODO
    public boolean podeVender(Long codigo, Integer quantidade) {
        return true;
    }
}
