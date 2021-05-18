package com.bcopstein.adaptadores.conectores;

import com.bcopstein.negocio.entidades.ItemEstoque;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstoqueJpa extends JpaRepository<ItemEstoque, Long> {

}
