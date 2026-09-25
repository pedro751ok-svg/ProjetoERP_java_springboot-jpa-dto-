package com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Domain;

import java.math.BigDecimal;

public interface RegrasDeDescontoDeBeneficio {
    BigDecimal descontoBeneficio(BigDecimal salario);
}
