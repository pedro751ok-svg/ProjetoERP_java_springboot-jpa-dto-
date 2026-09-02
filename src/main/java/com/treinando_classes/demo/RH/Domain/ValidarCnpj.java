package com.treinando_classes.demo.RH.Domain;

public class ValidarCnpj {
    public static boolean validar(String cnpj) {
        if (cnpj == null) {
            return false;
        }
        cnpj = cnpj.replaceAll("\\D", "");

        if (cnpj.length() != 14) {
            return false;
        }
            if (cnpj.matches("(\\d)\\1{13}"))
                return false;

            int[] pesos_1 = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
            int[] pesos_2 = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
//primeiro digito
            int soma = 0;
            for (int i = 0; i < 12; i++) {
                soma += Character.getNumericValue(cnpj.charAt(i)) * pesos_1[i];
            }
            int resto = soma % 11;
            int digito1 = resto < 2 ? 0 : 11 - resto;
            //degundo digito

            soma = 0;

            for (int i = 0; i < 13; i++) {
                soma += Character.getNumericValue(cnpj.charAt(i)) * pesos_2[i];
            }
            resto = soma % 11;
            int digito2 = resto < 2 ? 0 : 11 - resto;

            //confere os dois digitos
            return digito1 == Character.getNumericValue(cnpj.charAt(12))
                    && digito2 == Character.getNumericValue((cnpj.charAt(13)));
        }
    }


