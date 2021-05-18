package com.bcopstein.adaptadores.conectores;

import com.bcopstein.negocio.entidades.Venda;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaJpa extends JpaRepository<Venda, Long>{
    
    

}
