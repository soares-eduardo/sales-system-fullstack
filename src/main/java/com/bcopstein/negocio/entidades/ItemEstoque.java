package com.bcopstein.negocio.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "estoque")
public class ItemEstoque {

    @Id
    @SequenceGenerator(name = "estoque_sequence", sequenceName = "estoque_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estoque_sequence")
    private Long codigo;
    private int quantidade;

    @OneToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    public ItemEstoque(Long codigo, int quantidade, Produto produto) {
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.produto = produto;
    }

    public ItemEstoque(int quantidade, Produto produto) {
        this.quantidade = quantidade;
        this.produto = produto;
    }

    public ItemEstoque(Long codigo, int quantidade) {
        this.codigo = codigo;
        this.quantidade = quantidade;
    }

    public ItemEstoque() {

    }

    public Long getCodigo() {
        return codigo;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}