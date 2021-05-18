package com.bcopstein.adaptadores.controladores;

import java.util.ArrayList;
import java.util.List;

import com.bcopstein.negocio.entidades.ItemCarrinho;
import com.bcopstein.negocio.entidades.Produto;

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

	@GetMapping
	public List<Produto> getProdutos() {
		return List.of(new Produto("Teste 1", 20));
	}

	// @GetMapping("/produtos")
	// @CrossOrigin(origins = "*")
	// public List<Produto> listaProdutos() {

	// }

	// @GetMapping("/autorizacao")
	// @CrossOrigin(origins = "*")
	// public boolean podeVender(@RequestParam final Integer codProd,
	// @RequestParam final Integer qtdade) {

	// }

	// @PostMapping("/confirmacao")
	// @CrossOrigin(origins = "*")
	// public boolean confirmaVenda(@RequestBody final ItemCarrinho[] itens) {

	// }

	// @GetMapping("/historico")
	// @CrossOrigin(origins = "*")
	// public List<String> vendasEfetuadas() {

	// }

	// @PostMapping("/subtotal")
	// @CrossOrigin(origins = "*")
	// public Integer[] calculaSubtotal(@RequestBody final ItemCarrinho[] itens) {

	// }
}
