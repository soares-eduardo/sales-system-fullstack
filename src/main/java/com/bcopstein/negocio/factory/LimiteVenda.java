package com.bcopstein.negocio.factory;

import java.util.List;
import com.bcopstein.negocio.entidades.ItemEstoque;

public interface LimiteVenda {
    
    boolean temRestricao(List<ItemEstoque> itens);

}
