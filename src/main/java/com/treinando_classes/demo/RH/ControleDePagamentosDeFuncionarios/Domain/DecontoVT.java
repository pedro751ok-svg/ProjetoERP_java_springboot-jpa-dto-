package com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Domain;

import com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Interface.BeneficoTransport;

import java.math.BigDecimal;

public class  DecontoVT implements BeneficoTransport {
    @Override
    public BigDecimal descontoBeneficio(BigDecimal salario){
        return salario.multiply(new BigDecimal("0.06"));    }
}
