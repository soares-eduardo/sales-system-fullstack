package com.bcopstein.negocio.factory;

import java.util.Calendar;
import java.util.GregorianCalendar;

import com.bcopstein.aplicacao.factory.HorarioComercial;
import com.bcopstein.aplicacao.factory.HorarioNaoComercial;

import org.springframework.stereotype.Component;

@Component
public class LimiteVendaFactory {

    public LimiteVenda getInstance() {

        int hora = GregorianCalendar.getInstance().get(Calendar.HOUR_OF_DAY);

        if (hora > 9 && hora < 18) {
            return new HorarioComercial();
        }
        return new HorarioNaoComercial();
    }
}
