class Carrinho {
  mudarQuantidade(codProd, qtdade) {
    if (Number.isNaN(qtdade) || qtdade <= 0) return;

    let item = this.recuperarItem(codProd);
    if (item === undefined) return;
    item.qtdade = qtdade;
  }

  recuperarItem(codProd) {
    return this.itens.find((x) => x.produto.codigo == codProd);
  }

  adicionarItem(item) {
    this.itens.push(item);
  }

  limpar() {
    this.itens = [];
  }

  constructor() {
    this.itens = [];
  }
}
