package com.bcopstein.adaptadores.repositorios;
import java.util.List;
import java.util.Optional;

import com.bcopstein.adaptadores.conectores.ProdutoJpa;
import com.bcopstein.negocio.entidades.Produto;
import com.bcopstein.negocio.repositorios.IProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProdutoRepository implements IProdutoRepository{
    
    private ProdutoJpa produtoJpa;

    @Autowired
    public ProdutoRepository(ProdutoJpa produtoJpa) {
        this.produtoJpa = produtoJpa;
    }

    public List<Produto> getAllProdutos() {
        return produtoJpa.findAll();
    }

    public Optional<Produto> getProdutoById(Long id) {
        return produtoJpa.findById(id);
    }

}
