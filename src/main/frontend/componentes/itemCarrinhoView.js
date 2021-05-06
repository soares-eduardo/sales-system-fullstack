class ItemCarrinhoView {
  definirQuantidade(qtd) {
    const preco = (this.itemCarrinho.produto.preco * qtd).toFixed(2);
    this.preco.textContent = "R$ " + preco;
    this.qtd.value = qtd;

    this.itemCarrinho.qtdade = qtd;
  }

  criarElemento() {
    if (this.elemento) return this.elemento;

    let template = `
      <div class="produto">  
        <div class="inner">
          <div class="descricao"></div>
          <div class="preco"></div>
          <div class="qtd">
            <label>Qtd:</label>
            <input type="text" value="1" />
          </div>
        </div>
      </div>
    `.trim();

    let temp = document.createElement("template");
    temp.innerHTML = template;
    const elemento = temp.content.firstChild;

    this.descricao = elemento.querySelector(".descricao");
    this.preco = elemento.querySelector(".preco");
    this.qtd = elemento.querySelector("input");

    this.descricao.innerHTML = this.itemCarrinho.produto.descricao;
    this.definirQuantidade(this.itemCarrinho.qtdade);

    this.elemento = elemento;
    return elemento;
  }

  remover() {
    if (this.elemento) this.elemento.remove();
    this.elemento = null;
  }

  constructor(itemCarrinho) {
    this.itemCarrinho = itemCarrinho;
    this.descricao = null;
    this.elemento = null;
    this.preco = null;
    this.qtd = null;
  }
}
