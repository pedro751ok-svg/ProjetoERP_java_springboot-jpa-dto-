package com.treinando_classes.demo.RH.Auth.Authenticacao;
import com.treinando_classes.demo.RH.Auth.Repository.EmpresaRepository;
import com.treinando_classes.demo.Shared.Dto_And_Mapper.EmpresaDto;
import com.treinando_classes.demo.Shared.Dto_And_Mapper.Mapper.EmpresaMapper;
import com.treinando_classes.demo.RH.utils.CriptografiaDeSenhas;
import com.treinando_classes.demo.Shared.Empresa;

import java.util.Optional;

public class LoginEmpresas {
    private final EmpresaRepository repository;
    private final CriptografiaDeSenhas criptografiaDeSenhas;
    private final EmpresaMapper.MapperEmpresa empresamapper;
    public LoginEmpresas(EmpresaRepository repository, CriptografiaDeSenhas criptografiaDeSenhas, EmpresaMapper.MapperEmpresa empresamapper){
        this.repository = repository;
        this.criptografiaDeSenhas = criptografiaDeSenhas;
        this.empresamapper = empresamapper;

    }

    public EmpresaDto empresa(String cnpj, String senha) {
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
        return empresamapper.toDto(empresa_encontrada);
    }
}
