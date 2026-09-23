package com.treinando_classes.demo.RH.Auth.Authenticacao;
import com.treinando_classes.demo.RH.Auth.Repository.CadastroRepository;
import com.treinando_classes.demo.Shared.Dto_And_Mapper.FuncionarioDTO;
import com.treinando_classes.demo.Shared.Dto_And_Mapper.Mapper.FuncionarioMapper;
import org.springframework.stereotype.Service;
import com.treinando_classes.demo.Shared.Funcionario;
import com.treinando_classes.demo.RH.FeriasAtestadosAfastamentos.Domain.utils.CriptografiaDeSenhas;

import java.util.Optional;

@Service
public class LoginFuncionario {

    private final CadastroRepository repository;
    private final CriptografiaDeSenhas criptografiaDeSenhas;
    private final FuncionarioMapper.MapperFuncionario funcionarioMapper;

    public LoginFuncionario(CadastroRepository repository, CriptografiaDeSenhas criptografiaDeSenhas, FuncionarioMapper.MapperFuncionario funcionarioMapper) {
        this.repository = repository;
        this.criptografiaDeSenhas = criptografiaDeSenhas;
        this.funcionarioMapper = funcionarioMapper;
    }

    public FuncionarioDTO funcionario(String cpf, String senhaDigitada) {

        Optional<Funcionario> cadastro_registrado = repository.findFirstByCpf(
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
        return funcionarioMapper.toDto(funcionario_encontrado);
    }
}

