package com.treinando_classes.demo.RH.Domain;
import jakarta.persistence.metamodel.StaticMetamodel;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CriptografiaDeSenhas {
    private final PasswordEncoder passwordEncoder;

    public  CriptografiaDeSenhas (PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }

    public  String gerar_hash(String senha){
        return passwordEncoder.encode(senha);

    }

    public  boolean verificar_hash(String SenhaDigitada, String HashSalvo){
        return passwordEncoder.matches(SenhaDigitada, HashSalvo);
    }


}
