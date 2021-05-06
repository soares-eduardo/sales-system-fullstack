class SaidaView {
  icError = "&#x26D4"; // ⛔
  icOk = "&#x2705"; // ✅

  erroInternoDoServidor() {
    this.root.innerHTML = this.icError + " Erro Interno do Servidor";
  }

  quantidadeIndisponivel() {
    this.root.innerHTML =
      this.icError + " Quantidade excede o dispon&iacute;vel para o produto";
  }

  produtoIndisponivel() {
    this.root.innerHTML = this.icError + " Produto Indispon&iacute;vel";
  }

  vendaSucesso() {
    this.root.innerHTML = this.icOk + " Venda conclu&iacute;da com sucesso";
  }

  limpar() {
    this.root.innerHTML = "N&atilde;o h&aacute; nenhuma sa&iacute;da";
  }

  constructor(root) {
    this.root = root;
    this.limpar();
  }
}
