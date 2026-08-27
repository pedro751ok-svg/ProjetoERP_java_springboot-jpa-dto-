package com.treinando_classes.demo.RH.Domain;

public class Validarcpf {
    public boolean validar(String cpf) {
        if (cpf == null) {
            return false;
        }
        cpf = cpf.replaceAll("\\D", "");

        if (cpf.length() != 11) {
            return false;
        }
        if (cpf.matches("(\\d)\\1{10}"))
            return false;


        int[] peso_1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] peso_2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int soma = 0;

        for (int i = 0; i < 11; i++) {
            soma += Character.getNumericValue(cpf.charAt(i) * peso_1[i]);


        }
        return true;
    }
}

