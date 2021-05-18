package com.bcopstein.negocio.repositorios;

import com.bcopstein.negocio.entidades.Venda;

import org.springframework.data.repository.CrudRepository;

public interface IVendaRepository extends CrudRepository<Venda, Long>{
    
}
