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


        int[] peso_1 = {9,8,7,6,5,4,3,2,1};
        int[] peso_2 = {10,9,8,7,6,5,4,3,2,1};

        int soma = 0;

        for (int i = 0; i < 9; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * peso_1[i];


        }
        for (int y = 0; y < 10; y++) {
            soma += Character.getNumericValue(cpf.charAt(y)) * peso_2[y];
        }
        return true;
    }
}

