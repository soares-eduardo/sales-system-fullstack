// Referência para acentos e caracteres especiais em HTML/JS
// http://www.javascripter.net/faq/accentedcharacters.htm

const btnCheckout = document.getElementById("btnCheckout");
const btnClear = document.getElementById("btnClear");

const carrinhoRoot = document.getElementById("carrinho");
const produtosRoot = document.getElementById("produtos");
const saidaRoot = document.getElementById("txtSaida");
const totalRoot = document.getElementById("total");

var produtos;
var carrinho;
var servico;
var saida;
var total;

async function mudarQuantidade(itemCarrinhoView) {
  const codigo = itemCarrinhoView.itemCarrinho.produto.codigo;
  const valor = itemCarrinhoView.qtd.value;
  const num = Number.parseInt(valor);
  var qtdade = 1;

  if (!(Number.isNaN(num) || num < 1)) {
    qtdade = Math.floor(num);
    let autorizado = await servico.autoriza(codigo, qtdade);
    if (!autorizado) {
      saida.quantidadeIndisponivel();
      limparCarrinho();
      return;
    }
  }

  this.carrinho.mudarQuantidade(codigo, qtdade);
  await calcularSubtotal();
}

async function adicionarAoCarrinho(produto) {
  
  let qtd = await carrinho.quantidade(produto.codigo);
  
  if (qtd > 0) {
    let autorizado = await servico.autoriza(produto.codigo, qtd + 1);
    if (autorizado) {
      carrinho.mudarQuantidade(produto.codigo, qtd + 1);
    } else {
      return saida.quantidadeIndisponivel();
    }
  } else {
    let autorizado = await servico.autoriza(produto.codigo, 1);
    if (!autorizado) return saida.produtoIndisponivel();
    
    let view = carrinho.adicionarItem(produto);
    bindItem(view);
    
    btnCheckout.disabled = false;
    btnClear.disabled = false;
  }

  saida.limpar();
  await calcularSubtotal();
}

async function calcularSubtotal() {
  let itens = carrinho.carrinho.itens;

  totais = await servico.calculaSubtotal(itens);

  if (totais !== null) total.definirValores(totais[0], totais[1], totais[2]);
  else {
    saida.erroInternoDoServidor();
    total.limpar();
  }
}

async function carregarProdutos() {
  let lista_produtos = await servico.getProdutos();
  produtos.carregarProdutos(lista_produtos);
}

function limparCarrinho() {
  btnCheckout.disabled = true;
  btnClear.disabled = false;
  carrinho.limpar();
  total.limpar();
}

async function checkout() {
  let itens = carrinho.carrinho.itens;
  let confirmou = await servico.confirmaVenda(itens);

  console.log(confirmou);

  if (confirmou) {
    saida.vendaSucesso();
  } else {
    saida.erroInternoDoServidor();
  }
  limparCarrinho();
}

// Binding de eventos
function bindProdutos(produtoViews) {
  produtoViews.forEach((view) => {
    view.btnSelect.addEventListener("click", () => {
      adicionarAoCarrinho(view.produto);
    });
  });
}

function bindItem(itemView) {
  itemView.qtd.addEventListener("focusout", () => {
    this.mudarQuantidade(itemView);
  });
}

function bindCheckout(btn) {
  btn.addEventListener("click", checkout);
}

function bindClear(btn) {
  btn.addEventListener("click", limparCarrinho);
}

// Inicialização
async function init() {
  servico = new ServicoDeVendas("http://localhost:8080");

  carrinho = new CarrinhoView(new Carrinho(), carrinhoRoot);
  produtos = new ProdutoListView(servico, produtosRoot);
  saida = new SaidaView(saidaRoot);
  total = new TotalView(totalRoot);

  await carregarProdutos();

  bindProdutos(produtos.views);
  bindCheckout(btnCheckout);
  bindClear(btnClear);
}

init();
