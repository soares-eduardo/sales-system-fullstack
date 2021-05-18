package com.bcopstein.negocio.repositorios;

import java.util.List;
import java.util.Optional;

import com.bcopstein.negocio.entidades.Produto;

public interface IProdutoRepository {

    List<Produto> getAllProdutos();
    Optional<Produto> getProdutoById(Long id);
}
