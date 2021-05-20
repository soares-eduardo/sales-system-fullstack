package com.bcopstein.negocio.entidades;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import org.hibernate.annotations.CreationTimestamp;

/**
 * Venda
 */

@Entity
@Table(name = "venda")
public class Venda {

    @Id
    @SequenceGenerator(name = "venda_sequence", sequenceName = "venda_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "venda_sequence")
    private Long codigo;

    @CreationTimestamp
    @Column(name = "data")
    private LocalDateTime data;

    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<ItemVenda> itemVenda;

    public Venda() {
        this.itemVenda = new ArrayList<ItemVenda>();
    }

    public Long getCodigo() {
        return codigo;
    }

    public LocalDateTime getData() {
        return data;
    }

    public List<ItemVenda> getItemVenda() {
        return itemVenda;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public void setItemVenda(List<ItemVenda> itemVenda) {
        this.itemVenda = itemVenda;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}