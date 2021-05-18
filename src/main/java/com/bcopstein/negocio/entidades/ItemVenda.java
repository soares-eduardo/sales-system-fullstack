package com.bcopstein.negocio.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "itemVenda")
public class ItemVenda {

    @Id
    @SequenceGenerator(
        name = "itemVenda_sequence",
        sequenceName = "itemVenda_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "itemVenda_sequence"
    )
    private Long codigo;
    private int quantidade;
    private int precoUnitarioVenda;
    private Long imposto;


    //private Produto produto;

    @ManyToOne
    @JoinColumn(name = "venda_id")
    private Venda venda;

    public ItemVenda(Long codigo, int quantidade, int precoUnitarioVenda, Long imposto, Produto produto, Venda venda) {
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.precoUnitarioVenda = precoUnitarioVenda;
        this.imposto = imposto;
        //this.produto = produto;
        this.venda = venda;
    }

    public ItemVenda() {

    }

    public Venda getVenda() {
        return venda;
    }

    public Long getCodigo() {
        return codigo;
    }

    public Long getImposto() {
        return imposto;
    }

    public int getPrecoUnitarioVenda() {
        return precoUnitarioVenda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    // public Produto getProduto() {
    //     return produto;
    // }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public void setImposto(Long imposto) {
        this.imposto = imposto;
    }

    public void setPrecoUnitarioVenda(int precoUnitarioVenda) {
        this.precoUnitarioVenda = precoUnitarioVenda;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    // public void setProduto(Produto produto) {
    //     this.produto = produto;
    // }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}
