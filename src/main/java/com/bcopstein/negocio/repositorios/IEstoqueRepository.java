package com.bcopstein.negocio.repositorios;

import java.util.List;
import java.util.Optional;

import com.bcopstein.negocio.entidades.ItemEstoque;

public interface IEstoqueRepository {

    List<ItemEstoque> getAllItemEstoque();
    Optional<ItemEstoque> getItemEstoqueById(Long id);
    void insertItemEstoque(List<ItemEstoque> itemEstoque);
}
