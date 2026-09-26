package com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Interface;

import java.math.BigDecimal;
//interface pode ser usada para descontar dsr
public interface RegrasDeDescontosDeHoras {
    BigDecimal descontos_horas(BigDecimal ValorGanhoPorHora, BigDecimal HorasFaltantes);
}
