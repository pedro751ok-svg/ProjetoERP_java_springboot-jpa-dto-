package com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Domain;

import com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Interface.DescontoBeneficioInterface;

import java.math.BigDecimal;

public class DescontoVr implements DescontoBeneficioInterface {
    @Override
    public BigDecimal descontoBeneficio(BigDecimal ValorDoBeneficio){
        return ValorDoBeneficio.multiply(new BigDecimal( "0.20"));
    }
}
