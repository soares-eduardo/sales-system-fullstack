package com.bcopstein.adaptadores.conectores;

import com.bcopstein.negocio.entidades.Produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoJpa extends JpaRepository<Produto, Long>{
    
}
