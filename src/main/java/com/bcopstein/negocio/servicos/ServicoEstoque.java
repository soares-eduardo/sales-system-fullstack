package com.bcopstein.negocio.servicos;

import java.util.List;
import java.util.Optional;

import com.bcopstein.negocio.entidades.ItemEstoque;
import com.bcopstein.negocio.repositorios.IEstoqueRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoEstoque {

    private IEstoqueRepository estoqueRepository;

    @Autowired
    public ServicoEstoque(IEstoqueRepository estoqueRepository) {
        this.estoqueRepository = estoqueRepository;
    }

    // TODO
    public boolean podeVender(Long codigo, Integer quantidade) {

        ItemEstoque item = estoqueRepository.getItemEstoqueById(codigo).orElseThrow(
                () -> new IllegalStateException("Produto de codigo " + codigo + " não foi encontrado no estoque."));

        if (item.getQuantidadeDisponivel() >= quantidade) {
            return true;
        }

        return false;
    }

    public List<ItemEstoque> listaProdutos() {
        return estoqueRepository.getAllItemEstoque();
    } 

}
