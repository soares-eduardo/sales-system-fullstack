package com.bcopstein.aplicacao.factory;

import com.bcopstein.negocio.factory.LimiteVenda;
import com.bcopstein.negocio.entidades.ItemEstoque;
import java.util.List;

public class HorarioComercial implements LimiteVenda{

    @Override
    public boolean temRestricao(List<ItemEstoque> itens) {
        return false;
    }
}
