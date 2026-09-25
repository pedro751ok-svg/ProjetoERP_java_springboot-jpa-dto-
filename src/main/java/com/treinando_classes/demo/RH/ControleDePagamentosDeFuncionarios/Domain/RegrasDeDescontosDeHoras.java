package com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Domain;

import java.math.BigDecimal;
//interface pode ser usada para descontar dsr
public interface RegrasDeDescontosDeHoras {
    BigDecimal calcular_descontos(BigDecimal ValorGanhoPorHora);
}
