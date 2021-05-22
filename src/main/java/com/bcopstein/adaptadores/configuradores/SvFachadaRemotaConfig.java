package com.bcopstein.adaptadores.configuradores;

import java.util.List;

import com.bcopstein.adaptadores.repositorios.EstoqueRepository;
import com.bcopstein.adaptadores.repositorios.ProdutoRepository;
import com.bcopstein.adaptadores.repositorios.VendaRepository;
import com.bcopstein.aplicacao.strategy.CalculoTaxaPaisDois;
import com.bcopstein.aplicacao.strategy.CalculoTaxaPaisUm;
import com.bcopstein.negocio.entidades.ItemEstoque;
import com.bcopstein.negocio.entidades.ItemVenda;
import com.bcopstein.negocio.entidades.Produto;
import com.bcopstein.negocio.entidades.Venda;
import com.bcopstein.negocio.strategy.ICalculoTaxaPais;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SvFachadaRemotaConfig {
    
    @Bean
    CommandLineRunner commandLineRunner(

        EstoqueRepository estoqueRepository,
        ProdutoRepository produtoRepository,
        VendaRepository vendaRepository    
    ){
        return args -> {

            Produto fogao = new Produto("Fogão", 699);
            Produto lavaRoupa = new Produto("Lava Roupa", 3099);
            Produto geladeira = new Produto("Geladeira", 2754);
            Produto lavaLouca = new Produto("Lava Louça", 1889);

            produtoRepository.insertProdutos(List.of(fogao, lavaRoupa, geladeira, lavaLouca));

            ItemEstoque fogaoEstoque = new ItemEstoque(3, fogao);
            ItemEstoque lavaRoupaEstoque = new ItemEstoque(5, lavaRoupa);
            ItemEstoque geladeiraEstoque = new ItemEstoque(2, geladeira);
            ItemEstoque lavaLoucaEstoque = new ItemEstoque(1, lavaLouca);

            estoqueRepository.insertItemEstoque(List.of(fogaoEstoque,lavaRoupaEstoque,geladeiraEstoque,lavaLoucaEstoque));

            Venda venda1 = new Venda();

            ItemVenda itemVenda1 = new ItemVenda(3, 2640, 10, geladeira, venda1);
            ItemVenda itemVenda2 = new ItemVenda(5, 550, 5, fogao, venda1);

            venda1.setItemVenda(List.of(itemVenda1,itemVenda2));

            vendaRepository.insertVendas(List.of(venda1));
        };
    }

    @Bean
    @ConditionalOnProperty(name = "calculo.taxa", havingValue = "um", matchIfMissing = true)
    public ICalculoTaxaPais setPaisUm() {
        return new CalculoTaxaPaisUm();
    }

    @Bean
    @ConditionalOnProperty(name = "calculo.taxa", havingValue = "dois")
    public ICalculoTaxaPais setPaisDois() {
        return new CalculoTaxaPaisDois();
    }
}
