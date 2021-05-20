package com.bcopstein.adaptadores.controladores;

import java.util.List;

import com.bcopstein.aplicacao.usecase.CalculaSubtotalUC;
import com.bcopstein.aplicacao.usecase.ConfirmaVendaUC;
import com.bcopstein.aplicacao.usecase.ListaProdutosUC;
import com.bcopstein.aplicacao.usecase.PodeVenderUC;
import com.bcopstein.aplicacao.usecase.VendasEfetuadasUC;
import com.bcopstein.negocio.entidades.ItemEstoque;
import com.bcopstein.negocio.entidades.Produto;
import com.bcopstein.negocio.entidades.Venda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vendas")
public class SvFachadaRemota {

	private CalculaSubtotalUC calculaSubtotalUC;
	private ConfirmaVendaUC confirmaVendaUC;
	private ListaProdutosUC listaProdutosUC;
	private PodeVenderUC podeVenderUC;
	private VendasEfetuadasUC vendasEfetuadasUC;

	@Autowired
	public SvFachadaRemota(CalculaSubtotalUC calculaSubtotalUC, ConfirmaVendaUC confirmaVendaUC,
			ListaProdutosUC listaProdutosUC, PodeVenderUC podeVenderUC, VendasEfetuadasUC vendasEfetuadasUC) {
		this.calculaSubtotalUC = calculaSubtotalUC;
		this.confirmaVendaUC = confirmaVendaUC;
		this.listaProdutosUC = listaProdutosUC;
		this.podeVenderUC = podeVenderUC;
		this.vendasEfetuadasUC = vendasEfetuadasUC;
	}

	@GetMapping("/produtos")
	@CrossOrigin(origins = "*")
	public List<ItemEstoque> listaProdutos() {
		return listaProdutosUC.run();
	}

	@GetMapping("/autorizacao")
	@CrossOrigin(origins = "*")
	public boolean podeVender(@RequestParam final Long codProd, @RequestParam final Integer qtdade) {
		return podeVenderUC.run(codProd, qtdade);
	}

	@PostMapping("/confirmacao")
	@CrossOrigin(origins = "*")
	public boolean confirmaVenda(@RequestBody final List<ItemEstoque> itens) {
		return confirmaVendaUC.run(itens);
	}

	@GetMapping("/historico")
	@CrossOrigin(origins = "*")
	public List<Venda> vendasEfetuadas() {
		return vendasEfetuadasUC.run();
	}

	@PostMapping("/subtotal")
	@CrossOrigin(origins = "*")
	public Integer[] calculaSubtotal(@RequestBody final List<ItemEstoque> itens) {
		return calculaSubtotalUC.run(itens);
	}
}