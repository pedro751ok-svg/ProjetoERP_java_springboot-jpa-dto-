package com.treinando_classes.demo.RH.services;
import com.treinando_classes.demo.Shared.Funcionario;
import org.springframework.stereotype.Service;
import com.treinando_classes.demo.RH.regras_Enums.RegrasDeEnums;
import com.treinando_classes.demo.RH.repositories.CadastroRepository;
import com.treinando_classes.demo.RH.Domain.Validarcpf;

@Service
public class Cadastros {

    private final CadastroRepository repository;
    public Cadastros(CadastroRepository repository) {
        this.repository = repository;


    }
    // salvando cadastros na tabela
    public Funcionario funcionario(String nome, String cpf, String email, RegrasDeEnums.setor setor, RegrasDeEnums.Cargo role){
        Validarcpf validador = new Validarcpf();
        if(!validador.validar(cpf)) {
            throw new IllegalArgumentException("cpf invalido");
        }
        if (repository.existByCpf(cpf)){
                throw new IllegalArgumentException("funcionario com esse cpf ja existe");
        }

        if(repository.existByEmail(email)){
            throw new IllegalArgumentException("funcionario com esse email ja existe");
        }
        Funcionario novo_funcionario = Funcionario.builder()
        .nome(nome)
        .cpf(cpf)
        .email(email)
        .setor(setor)
        .role(role)
        .build();

        return repository.save(novo_funcionario);
    }
}
