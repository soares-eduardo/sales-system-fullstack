package com.bcopstein.negocio.servicos;

import java.util.List;

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

    public boolean podeVender(Long codigo, Integer quantidade) {

        ItemEstoque item = estoqueRepository.getItemEstoqueById(codigo).orElseThrow(
                () -> new IllegalStateException("Produto de codigo " + codigo + " não foi encontrado no estoque."));

        if (item.getQuantidade() >= quantidade) {
            return true;
        }

        return false;
    }

    public List<ItemEstoque> listaItemEstoques() {
        return estoqueRepository.getAllItemEstoque();
    }

    //TODO
    public Integer[] calculaSubtotal(List<ItemEstoque> itens) {
        
        final double TAXA = 0.1;
        final Integer[] valores = new Integer[3];

        Integer imposto = 0;
        int subtotal = 0;
    
        for (ItemEstoque item : itens) {
            
            ItemEstoque itemEstoque = estoqueRepository.getItemEstoqueById(item.getCodigo()).orElseThrow(
                () -> new IllegalStateException("Produto de codigo " + item.getCodigo() + " não foi encontrado no estoque."));
            
            subtotal += itemEstoque.getProduto().getPrecoUnitario() * item.getQuantidade();
        }

        imposto = (int) (subtotal * TAXA);

        valores[0] = subtotal;
        valores[1] = imposto;
        valores[2] = subtotal + imposto;

        return valores;
    }
}
