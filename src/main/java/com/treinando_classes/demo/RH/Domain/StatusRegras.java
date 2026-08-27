package com.treinando_classes.demo.RH.Domain;
import com.treinando_classes.demo.RH.regras_Enums.RegrasDeEnums;

public class StatusRegras {
    public RegrasDeEnums.status EstadoDoStatus(String ReprovadoPor, String AprovadoPor) {
        Boolean temAprovador = !AprovadoPor.equals("PENDENTE");
        Boolean temReprovador = !ReprovadoPor.equals("PENDENTE");

        if (temAprovador && temReprovador) {
            throw new IllegalArgumentException("não e permitido uma aprovação e uma repovação ao mesmo tempo");
        }
        if(temAprovador){
            return RegrasDeEnums.status.APROVADO;
        }
        if(temReprovador){
            return RegrasDeEnums.status.REJEITADO;
        }
        return  RegrasDeEnums.status.PENDENTE;
    }
}
