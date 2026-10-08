package com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.ServiceControleSalarioFuncionario;
import com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Model.FolhaDePagamento;
import com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Repository.FolhaPagamentoRepository;
import com.treinando_classes.demo.Shared.Funcionario;
import com.treinando_classes.demo.RH.Auth.Repository.CadastroRepository;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.Optional;

public class RegistrarAsalariado {

    private final FolhaPagamentoRepository repository;
    private final CadastroRepository cadastroRepository;

    public RegistrarAsalariado(FolhaPagamentoRepository repository,CadastroRepository cadastroRepository){
        this.repository = repository;
        this.cadastroRepository = cadastroRepository;
    }
    public FolhaDePagamento RegistrarSalario(long id_funcionario, BigDecimal salario, BigDecimal totaldescontos, LocalTime horas_trabalhadas,
                                             LocalTime horas_extras, BigDecimal valor_ganho_por_hora, int mes, int dia){

        Optional<FolhaDePagamento> folhaexistente = repository.findById_funcionario(id_funcionario);

        if(folhaexistente.isPresent()){
            throw new IllegalArgumentException("essa folha de pagamento ja pertence a um funcionario ");
        }

        Funcionario funcionarioencontrado = cadastroRepository.findById(id_funcionario).
                orElseThrow(() -> new IllegalArgumentException("funcinario nao encontrado"));

        FolhaDePagamento novo_registro = FolhaDePagamento.builder()
                .id_funcionario(funcionarioencontrado)
                .Salario(salario)
                .TotalDescontos(totaldescontos)
                .HorasTrabalhadas(horas_trabalhadas)
                .HorasExtras(horas_extras)
                .ValorGanhoPorHora(valor_ganho_por_hora)
                .build();

        repository.save(novo_registro);
        return novo_registro;

    }
}
