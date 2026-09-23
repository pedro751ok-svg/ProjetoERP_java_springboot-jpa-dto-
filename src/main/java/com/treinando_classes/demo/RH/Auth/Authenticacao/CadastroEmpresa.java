package com.treinando_classes.demo.RH.Auth.Authenticacao;
import com.treinando_classes.demo.RH.FeriasAtestadosAfastamentos.Domain.utils.CriptografiaDeSenhas;
import com.treinando_classes.demo.RH.Auth.Repository.EmpresaRepository;
import com.treinando_classes.demo.RH.FeriasAtestadosAfastamentos.Domain.utils.ValidarCnpj;
import com.treinando_classes.demo.Shared.Empresa;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

public class CadastroEmpresa {
    @Service
    @Transactional
    public static class CadastroDeEmpresas {
        private final EmpresaRepository repository;
        private final CriptografiaDeSenhas criptografiaDeSenhas;
        public CadastroDeEmpresas(EmpresaRepository repository, CriptografiaDeSenhas criptografiaDeSenhas){
            this.repository = repository;
            this.criptografiaDeSenhas = criptografiaDeSenhas;
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
            String senha_criptografada = criptografiaDeSenhas.gerar_hash(senha);
            if(senha_criptografada == null){
                throw new IllegalArgumentException("senha nao foi salva devidamente no sistema, tente novamente mais tarde");
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
}
