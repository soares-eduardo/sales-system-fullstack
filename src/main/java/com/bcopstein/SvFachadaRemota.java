package com.bcopstein;

import java.util.ArrayList;
import java.util.List;

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
  private final List<Produto> produtos;
  private final List<String> vendasEfetuadas;

  public SvFachadaRemota() {
    // Cria e carrega o estoque
    produtos = new ArrayList<>();
    produtos.add(new Produto(10, "Geladeira", 2500.0, 10));
    produtos.add(new Produto(20, "Fogao", 1200.0, 0));
    produtos.add(new Produto(30, "Lava louça", 4300.0, 7));
    produtos.add(new Produto(40, "Lava roupa", 3350.0, 11));
    produtos.add(new Produto(50, "Aspirador de pó", 780.0, 22));

    // Cria a lista de vendas efetuadas
    vendasEfetuadas = new ArrayList<>();
  }

  @GetMapping("/produtos")
  @CrossOrigin(origins = "*")
  public List<Produto> listaProdutos() {
    return produtos;
  }

  @GetMapping("/autorizacao")
  @CrossOrigin(origins = "*")
  public boolean podeVender(@RequestParam final Integer codProd,
                            @RequestParam final Integer qtdade) {
    final boolean disponivel =
        produtos.stream().anyMatch(p -> p.getCodigo() == codProd && p.getQtdade() >= qtdade);
    return disponivel;
  }

  @PostMapping("/confirmacao")
  @CrossOrigin(origins = "*")
  public boolean confirmaVenda(@RequestBody final ItemCarrinho[] itens) {

    ArrayList<Produto> listaProdutos = new ArrayList<>();
    ArrayList<Integer> listaQtdades = new ArrayList<>();

    for (ItemCarrinho item : itens) {
      final Produto produto =
          produtos.stream().filter(p -> p.getCodigo() == item.getCodigo()).findAny().orElse(null);

      if (produto == null) {
        return false;
      }

      listaQtdades.add(item.getQuantidade());
      listaProdutos.add(produto);
    }

    StringBuilder builder = new StringBuilder();

    for (int i = 0; i < listaProdutos.size(); i++) {
      final Produto produto = listaProdutos.get(i);
      final int qtdade = listaQtdades.get(i);
      produto.saidaDeProduto(qtdade);

      builder.append(produto.getCodigo());
      builder.append(" ");
      builder.append(produto.getDescricao());
      builder.append(" ");
      builder.append(qtdade);
      builder.append("\n");
    }

    vendasEfetuadas.add(builder.toString());
    return true;
  }

  @GetMapping("/historico")
  @CrossOrigin(origins = "*")
  public List<String> vendasEfetuadas() {
    return vendasEfetuadas;
  }

  @PostMapping("/subtotal")
  @CrossOrigin(origins = "*")
  public Integer[] calculaSubtotal(@RequestBody final ItemCarrinho[] itens) {
    Integer subtotal = 0;
    Integer imposto = 0;

    for (final ItemCarrinho it : itens) {
      // Procurar o produto pelo código
      final Produto prod =
          produtos.stream().filter(p -> p.getCodigo() == it.getCodigo()).findAny().orElse(null);

      if (prod != null) {
        subtotal += (int) (prod.getPreco() * it.getQuantidade());
      } else {
        throw new IllegalArgumentException("Codigo invalido");
      }
    }
    imposto = (int) (subtotal * 0.1);
    final Integer[] resp = new Integer[3];
    resp[0] = subtotal;
    resp[1] = imposto;
    resp[2] = subtotal + imposto;
    return resp;
  }}
