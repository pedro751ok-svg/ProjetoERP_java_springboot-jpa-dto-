package com.treinando_classes.demo.RH.FeriasAtestadosAfastamentos.Domain.utils;
import java.util.regex.*;
public class ValidarEmail {

    public static boolean validaremail( String email){
        String Regexemail = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(Regexemail);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }
}
