package com.treinando_classes.demo.RH.services;
import com.treinando_classes.demo.RH.repositories.CadastroRepository;
import org.springframework.stereotype.Service;
import com.treinando_classes.demo.Shared.Funcionario;
import com.treinando_classes.demo.RH.Domain.CriptografiaDeSenhas;

import java.util.Optional;

@Service
public class Login {

    private final CadastroRepository repository;
    private final CriptografiaDeSenhas criptografiaDeSenhas;

    public Login(CadastroRepository repository, CriptografiaDeSenhas criptografiaDeSenhas) {
        this.repository = repository;
        this.criptografiaDeSenhas = criptografiaDeSenhas;
    }

    public Funcionario funcionario(String cpf, String senhaDigitada) {
        Optional<Funcionario> cadastro_registrado = repository
                .findFirstByCpf(
                        cpf
                        );
        if(cadastro_registrado.isEmpty()){
            throw new IllegalArgumentException("cpf ou senha nao existe, tente novamente");

        }
        Funcionario funcionario_encontrado = cadastro_registrado.get();
        boolean senha_correta = criptografiaDeSenhas.verificar_hash(
                senhaDigitada,
                funcionario_encontrado.getSenha()
        );
        if(!senha_correta){
            throw new IllegalArgumentException("senha incorreta");
        }
        return funcionario_encontrado;
    }
}

