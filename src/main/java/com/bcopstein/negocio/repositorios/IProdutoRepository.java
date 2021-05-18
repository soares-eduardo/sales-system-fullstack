package com.bcopstein.negocio.repositorios;

import com.bcopstein.negocio.entidades.Produto;

import org.springframework.data.repository.CrudRepository;

public interface IProdutoRepository extends CrudRepository<Produto, Long>{
    
}
