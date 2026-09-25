package com.treinando_classes.demo.RH.Auth.Authenticacao;
import com.treinando_classes.demo.DefinirCargos;
import com.treinando_classes.demo.CargoRepository;
import com.treinando_classes.demo.RH.Auth.Repository.CadastroRepository;
import com.treinando_classes.demo.Shared.Funcionario;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.treinando_classes.demo.RH.FeriasAtestadosAfastamentos.Domain.utils.Validarcpf;
import com.treinando_classes.demo.EnumsDaRaiz.EnumsParaUsoGeral;
import com.treinando_classes.demo.RH.FeriasAtestadosAfastamentos.Domain.utils.CriptografiaDeSenhas;

@Service
@Transactional
public class CadastroFuncionario {

    private final CadastroRepository repository;
    private final CriptografiaDeSenhas criptografiaDeSenhas;
    private final CargoRepository cargoRepository;
    public CadastroFuncionario(CadastroRepository repository, CriptografiaDeSenhas criptografiaDeSenhas,
                               CargoRepository cargoRepository) {
        this.repository = repository;
        this.criptografiaDeSenhas = criptografiaDeSenhas;
        this.cargoRepository = cargoRepository;
    }
    // salvando cadastros na tabela
    public Funcionario funcionario(String nome, String cpf, String email,String senha, EnumsParaUsoGeral.Setor setor, long IdCargo ){
        Validarcpf validador = new Validarcpf();

        DefinirCargos cargo_atribuido = cargoRepository.findById(IdCargo).
                orElseThrow(() -> new IllegalArgumentException("Cargo não encontrado"));

        if(cargo_atribuido != null){
            throw new IllegalArgumentException("cargo do funcionario nao foi atribuido");
        }

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
        .IdCargo(cargo_atribuido)
        .build();


        return repository.save(novo_funcionario);
    }
}
