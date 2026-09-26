package com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Domain;

import com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Interface.RegrasDeDescontosDeHoras;

import java.math.BigDecimal;

public class DescontoHoras implements RegrasDeDescontosDeHoras {
    @Override
    public BigDecimal descontos_horas(BigDecimal ValorGanhoPorHora, BigDecimal HorasFaltantes){
        return ValorGanhoPorHora.multiply(HorasFaltantes);
    }
}
