package com.treinando_classes.demo.RH.services;
import com.treinando_classes.demo.RH.repositories.EmpresaRepository;
import com.treinando_classes.demo.RH.Domain.CriptografiaDeSenhas;
import com.treinando_classes.demo.RH.repositories.EmpresaRepository;
import com.treinando_classes.demo.Shared.Empresa;

import java.util.Optional;

public class LoginEmpresas {
    private final EmpresaRepository repository;
    private final CriptografiaDeSenhas criptografiaDeSenhas;
    public LoginEmpresas(EmpresaRepository repository, CriptografiaDeSenhas criptografiaDeSenhas){
        this.repository = repository;
        this.criptografiaDeSenhas = criptografiaDeSenhas;

    }

    public Empresa empresa(String cnpj, String senha) {
        Optional<Empresa> empresa_cadastrada = repository.findByCnpj(
                cnpj
        );
        if (empresa_cadastrada.isEmpty()) {
            throw new IllegalArgumentException("nenhuma empresa com cnpj encontrada, tente se cadastrar primeiro");
        }
        Empresa empresa_encontrada = empresa_cadastrada.get();
        boolean senha_correta = criptografiaDeSenhas.verificar_hash(
                senha,
                empresa_encontrada.getSenha()
        );
        if(!senha_correta){
            throw new IllegalArgumentException("senha incorreta tente novamente");
        }
        return empresa_encontrada;
    }
}
