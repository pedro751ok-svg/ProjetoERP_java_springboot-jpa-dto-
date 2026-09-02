package com.treinando_classes.demo.RH.services;
import com.treinando_classes.demo.Shared.Funcionario;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.treinando_classes.demo.RH.regras_Enums.RegrasDeEnums;
import com.treinando_classes.demo.RH.repositories.CadastroRepository;
import com.treinando_classes.demo.RH.Domain.Validarcpf;
import com.treinando_classes.demo.EnumsDaRaiz.EnumsParaUsoGeral;
@Service
@Transactional
public class Cadastros {

    private final CadastroRepository repository;
    public Cadastros(CadastroRepository repository) {
        this.repository = repository;


    }
    // salvando cadastros na tabela
    public Funcionario funcionario(String nome, String cpf, String email, EnumsParaUsoGeral.Setor setor ){
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
        .build();

        return repository.save(novo_funcionario);
    }
}
