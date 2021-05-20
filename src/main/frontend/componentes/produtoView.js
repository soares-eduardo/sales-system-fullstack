class ProdutoView {
  criarElemento() {
    let template = `
      <div class="produto">  
        <div class="inner">
          <div class="descricao"></div>
          <div class="preco"></div>
          <button class="select">Selecionar</button>
        </div>
      </div>
    `.trim();

    let temp = document.createElement("template");
    temp.innerHTML = template;
    const elemento = temp.content.firstChild;

    const descricao = elemento.querySelector(".descricao");
    const select = elemento.querySelector(".select");
    const preco = elemento.querySelector(".preco");

    preco.innerHTML = "R$ " + this.produto.precoUnitario.toFixed(2);
    descricao.innerHTML = this.produto.descricao;
    this.btnSelect = select;

    return elemento;
  }

  constructor(produto) {
    this.produto = produto;
    this.btnSelect = null;
  }
}
