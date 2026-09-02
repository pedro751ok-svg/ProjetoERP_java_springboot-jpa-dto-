package com.treinando_classes.demo.RH.services;
import com.treinando_classes.demo.Shared.Empresa;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.treinando_classes.demo.RH.Domain.ValidarCnpj;
import com.treinando_classes.demo.RH.repositories.EmpresaRepository;
@Service
@Transactional
public class CadastroDeEmpresas {
    private final EmpresaRepository repository;
    public CadastroDeEmpresas(EmpresaRepository repository){

        this.repository = repository;
    }
    public Empresa empresa(String nome, String Cnpj, String EmailCorporativo, String senha) {
        ValidarCnpj validarCnpj = new ValidarCnpj();
        if (!validarCnpj.validar(Cnpj)) {
            throw new IllegalArgumentException("cnpj invalido ");
        }
        if (repository.existsByCnpj(Cnpj)) {
            throw new IllegalArgumentException("esse cnpj ja esta cadastrado");
        }
        if (repository.existsByEmailCorporativo(EmailCorporativo)) {
            throw new IllegalArgumentException("esse email corporativo ja existe");
        }
        Empresa nova_empresa = Empresa.builder()
        .nome_empresa(nome)
        .Cnpj(Cnpj)
        .EmailCorporativo(EmailCorporativo)
        .senha(senha)
        .build();

        return repository.save(nova_empresa);

    }
}
