package com.bcopstein.adaptadores.repositorios;

import java.util.List;
import java.util.Optional;

import com.bcopstein.adaptadores.conectores.VendaJpa;
import com.bcopstein.negocio.entidades.Venda;
import com.bcopstein.negocio.repositorios.IVendaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VendaRepository implements IVendaRepository{
    
    private VendaJpa vendaJpa;

    @Autowired
    public VendaRepository(VendaJpa vendaJpa) {
        this.vendaJpa = vendaJpa;
    }

    public List<Venda> getAllVendas() {
        return vendaJpa.findAll();
    }

    public Optional<Venda> getVendaById(Long id) {
        return vendaJpa.findById(id);
    }

}
