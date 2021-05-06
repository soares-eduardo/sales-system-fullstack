class CarrinhoView {
  mudarQuantidade(codProd, qtdade) {
    let view = this.views.find(
      (view) => view.itemCarrinho.produto.codigo === codProd
    );

    if (view === undefined) return;

    this.carrinho.mudarQuantidade(codProd, qtdade);
    view.definirQuantidade(qtdade);
  }

  mostrarTextoVazio(mostrar) {
    if (mostrar) this.txtVazio.style.display = "block";
    else this.txtVazio.style.display = "none";
  }

  adicionarItem(produto) {
    let item = new ItemCarrinho(produto, 1);
    let view = new ItemCarrinhoView(item);

    this.carrinho.adicionarItem(item);
    this.views.push(view);

    let elemento = view.criarElemento();
    this.root.appendChild(elemento);
    this.mostrarTextoVazio(false);

    return view;
  }

  quantidade(codProd) {
    let item = this.carrinho.recuperarItem(codProd)
    if (item === undefined) return -1;
    return item.qtdade;
  }

  limpar() {
    this.views.forEach((x) => x.remover());
    this.mostrarTextoVazio(true);
    this.carrinho.limpar();
    this.views = [];
  }

  constructor(carrinho, root) {
    this.txtVazio = root.querySelector("p");
    this.carrinho = carrinho;
    this.root = root;
    this.views = [];
  }
}
