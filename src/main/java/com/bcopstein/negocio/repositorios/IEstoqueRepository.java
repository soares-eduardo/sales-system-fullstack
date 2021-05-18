package com.bcopstein.negocio.repositorios;

import com.bcopstein.negocio.entidades.ItemEstoque;

import org.springframework.data.repository.CrudRepository;

public interface IEstoqueRepository extends CrudRepository<ItemEstoque, Long>{
    
}
