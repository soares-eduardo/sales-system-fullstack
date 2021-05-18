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
    private int quantidadeDisponivel;

    @OneToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    public ItemEstoque(Long codigo, int quantidadeDisponivel, Produto produto) {
        this.codigo = codigo;
        this.quantidadeDisponivel = quantidadeDisponivel;
        this.produto = produto;
    }

    public ItemEstoque(int quantidadeDisponivel, Produto produto) {
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