package com.bcopstein;

public class ItemCarrinho {
  private int codigo;
  private int quantidade;

  public ItemCarrinho(int codigo, int quantidade) {
    this.codigo = codigo;
    this.quantidade = quantidade;
  }

  public int getCodigo() {
    return codigo;
  }

  public void setCodigo(int codigo) {
    this.codigo = codigo;
  }

  public int getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(int quantidade) {
    this.quantidade = quantidade;
  }

  @Override
  public String toString() {
    return "ItemCarrinho [codigo=" + codigo + ", qtd=" + quantidade + "]";
  }
}
