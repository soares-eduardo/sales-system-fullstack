package com.bcopstein.adaptadores.repositorios;

import java.util.List;
import java.util.Optional;

import com.bcopstein.adaptadores.conectores.EstoqueJpa;
import com.bcopstein.negocio.entidades.ItemEstoque;
import com.bcopstein.negocio.repositorios.IEstoqueRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EstoqueRepository implements IEstoqueRepository {

    private EstoqueJpa estoqueJpa;

    @Autowired
    public EstoqueRepository(EstoqueJpa estoqueJpa) {
        this.estoqueJpa = estoqueJpa;
    }

    public List<ItemEstoque> getAllItemEstoque() {
        return estoqueJpa.findAll();
    }

    public Optional<ItemEstoque> getItemEstoqueById(Long id) {
        return estoqueJpa.findById(id);
    }
}