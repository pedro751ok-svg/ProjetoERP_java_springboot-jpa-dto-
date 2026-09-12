package com.treinando_classes.demo.RH.Auth.Authenticacao;
import com.treinando_classes.demo.RH.Auth.Repository.CadastroRepository;
import com.treinando_classes.demo.Shared.Funcionario;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.treinando_classes.demo.RH.utils.Validarcpf;
import com.treinando_classes.demo.EnumsDaRaiz.EnumsParaUsoGeral;
import com.treinando_classes.demo.RH.utils.CriptografiaDeSenhas;
@Service
@Transactional
public class CadastroFuncionario {

    private final CadastroRepository repository;
    private final CriptografiaDeSenhas criptografiaDeSenhas;
    public CadastroFuncionario(CadastroRepository repository, CriptografiaDeSenhas criptografiaDeSenhas) {
        this.repository = repository;
        this.criptografiaDeSenhas = criptografiaDeSenhas;
    }
    // salvando cadastros na tabela
    public Funcionario funcionario(String nome, String cpf, String email,String senha, EnumsParaUsoGeral.Setor setor ){
        Validarcpf validador = new Validarcpf();
        if(!validador.validar(cpf)) {
            throw new IllegalArgumentException("cpf invalido");
        }
        if (repository.existsByCpf(cpf)){
                throw new IllegalArgumentException("funcionario com esse cpf ja existe");
        }

        if(repository.existsByEmail(email)){
            throw new IllegalArgumentException("funcionario com esse email ja existe");
        }
        String senha_criptografada = criptografiaDeSenhas.gerar_hash(senha);
        if(senha_criptografada == null) {
            throw new IllegalArgumentException("senha nao foi salva devidamente no sistema, tente novamente mais tarde");
        }
        Funcionario novo_funcionario = Funcionario.builder()
        .nome(nome)
        .cpf(cpf)
        .email(email)
        .senha(senha_criptografada)
        .setor(setor)
        .build();

        return repository.save(novo_funcionario);
    }
}
