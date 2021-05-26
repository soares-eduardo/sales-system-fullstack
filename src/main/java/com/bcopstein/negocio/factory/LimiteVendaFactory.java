package com.bcopstein.negocio.factory;

import java.util.Calendar;
import java.util.GregorianCalendar;

import com.bcopstein.aplicacao.factory.HorarioComercial;
import com.bcopstein.aplicacao.factory.HorarioNaoComercial;
import com.bcopstein.aplicacao.factory.LimiteVenda;

public class LimiteVendaFactory {

    private int hora = GregorianCalendar.getInstance().get(Calendar.HOUR_OF_DAY);

    public LimiteVenda getInstance() {
        if (hora > 9 && hora < 18){
            return new HorarioComercial();
        } 
        return new HorarioNaoComercial();
    }
}
