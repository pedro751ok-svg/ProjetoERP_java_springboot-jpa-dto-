package com.treinando_classes.demo.RH.Domain;
import com.treinando_classes.demo.RH.regras_Enums.RegrasDeEnums;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public class EstadoSolicitacao {
    public static   RegrasDeEnums.status Atestados(LocalDate DataInicio, LocalDate DataFim) {
        long days = ChronoUnit.DAYS.between(DataInicio, DataFim) + 1;
        if (days > 15) {
            return RegrasDeEnums.status.ENCAMINHADO;
        }
        return RegrasDeEnums.status.PENDENTE;
    }

    public static boolean PeriodoDeFeriasValido(long dias, int periodotirado) {
        if (dias < 5) {
            return false;
        }
        if (periodotirado == 0 && dias < 14) {
            return true;
        }
        return true;
    }

    public static RegrasDeEnums.status ferias(LocalDate DataInicio, LocalDate DataFim, int periodotirado) {
        long days = ChronoUnit.DAYS.between(DataInicio, DataFim) + 1;

        if (PeriodoDeFeriasValido(days, periodotirado)) {
            return RegrasDeEnums.status.APROVADO;
        }
        if (days > 30) {
            throw new IllegalArgumentException("dias nao pode ultaprassar a data determinada pelo ministerio do trabalho");
        }
        return RegrasDeEnums.status.PENDENTE;
    }

    public static RegrasDeEnums.status Afastamentos(LocalDate DataInicio, LocalDate DataFim) {
        if (DataInicio.isAfter(DataFim)) {
            throw new IllegalArgumentException("a data de inicio nao pode ser maior que a data de fim");
        }
        long days = ChronoUnit.DAYS.between(DataInicio, DataFim) + 1;

        return RegrasDeEnums.status.PENDENTE;
    }
}