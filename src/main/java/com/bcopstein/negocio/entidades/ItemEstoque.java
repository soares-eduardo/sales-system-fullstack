package com.bcopstein.negocio.entidades;

public class ItemEstoque {

    private Long codigo;
    private int quantidadeDisponivel;
    private Produto produto;

    public ItemEstoque(Long codigo, int quantidadeDisponivel, Produto produto) {
        this.codigo = codigo;
        this.quantidadeDisponivel = quantidadeDisponivel;
        this.produto = produto;
    }

    public ItemEstoque() {
        
    }

    public Long getCodigo() {
        return codigo;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setQuantidadeDisponivel(int quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}