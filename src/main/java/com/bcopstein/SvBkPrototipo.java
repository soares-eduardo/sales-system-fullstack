package com.bcopstein;

import java.util.Arrays;
import java.util.List;

import com.bcopstein.negocio.entidades.ItemEstoque;
import com.bcopstein.negocio.entidades.ItemVenda;
import com.bcopstein.negocio.entidades.Produto;
import com.bcopstein.negocio.entidades.Venda;
import com.bcopstein.negocio.repositorios.IEstoqueRepository;
import com.bcopstein.negocio.repositorios.IProdutoRepository;
import com.bcopstein.negocio.repositorios.IVendaRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "com.bcopstein" })
// @EnableJpaRepositories(basePackages = {"com.bcopstein"})
@EntityScan(basePackages = { "com.bcopstein" })
public class SvBkPrototipo {
	public static void main(String[] args) {

		//TO DO Desfazer isso
		ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(SvBkPrototipo.class, args);

		IVendaRepository vendaRepository = configurableApplicationContext.getBean(IVendaRepository.class);
		IProdutoRepository produtoRepository = configurableApplicationContext.getBean(IProdutoRepository.class);
		IEstoqueRepository estoqueRepository = configurableApplicationContext.getBean(IEstoqueRepository.class);

		Venda venda = new Venda();
		

		Produto produto1 = new Produto("Brinquedo", 15.0);
		Produto produto2 = new Produto("Lavadora", 100);

		produtoRepository.save(produto1);
		produtoRepository.save(produto2);

		ItemEstoque itemEstoque1 = new ItemEstoque(3, produto1);
		ItemEstoque itemEstoque2 = new ItemEstoque(5, produto2);

		estoqueRepository.save(itemEstoque1);
		estoqueRepository.save(itemEstoque2);

		ItemVenda venda1 = new ItemVenda(5, 12, 20.0, produto1, venda);
		ItemVenda venda2 = new ItemVenda(1, 98, 15.0, produto2, venda);

		List<ItemVenda> listItemVenda = Arrays.asList(venda1, venda2);

		venda.setItemVenda(listItemVenda);
		vendaRepository.save(venda);
		
	}
}
