package com.bcopstein.negocio.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


public class Produto {

  
  private Long codigo;
  private String descricao;
  private double precoUnitario;

  public Produto(Long codigo, String descricao, double precoUnitario) {
    this.codigo = codigo;
    this.descricao = descricao;
    this.precoUnitario = precoUnitario;
  }

  public Produto(String descricao, double precoUnitario) {
    this.descricao = descricao;
    this.precoUnitario = precoUnitario;
  }

  public Produto() {
    
  }

  public Long getCodigo() {
    return codigo;
  }

  public String getDescricao() {
    return descricao;
  }

  public double getPrecoUnitario() {
    return precoUnitario;
  }

  public void setPrecoUnitario(double precoUnitario) {
    this.precoUnitario = precoUnitario;
  }

  @Override
  public String toString() {
    return "Produto [codigo=" + codigo + ", descricao=" + descricao + ", preco=" + precoUnitario + "]";
  }
}
