package com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.ServiceControleSalarioFuncionario;

import com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Model.Beneficios;
import com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Model.FolhaDePagamento;
import com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Model.SalarioDescontado;
import com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Repository.BeneficiosRepository;
import com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Repository.FolhaPagamentoRepository;
import com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Repository.SalarioDescontadoRepository;
import jakarta.persistence.Id;

import java.util.Optional;

public class LeituraDeDados {

    private final BeneficiosRepository beneficiosRepository;
    private final FolhaPagamentoRepository folhaPagamentoRepository;
    private final SalarioDescontadoRepository salarioDescontadoRepository;

    public LeituraDeDados(
            BeneficiosRepository beneficiosRepository,
            FolhaPagamentoRepository folhaPagamentoRepository,
            SalarioDescontadoRepository salarioDescontadoRepository
    ) {
        this.beneficiosRepository = beneficiosRepository;
        this.folhaPagamentoRepository = folhaPagamentoRepository;
        this.salarioDescontadoRepository = salarioDescontadoRepository;
    }

    public Beneficios buscar_beneficio(long IdBeneficio) {
        Optional<Beneficios> resultadoDaBusca = beneficiosRepository.findById(IdBeneficio);

        if (resultadoDaBusca.isEmpty()) {
            throw new IllegalArgumentException("Nenhum benefício com esse ID encontrado");
        }

        return resultadoDaBusca.get();
    }

    public FolhaDePagamento BuscarFolhaDePagament(long IdFolhaPagamento) {
        Optional<FolhaDePagamento> resultadoBuscaDaFolha = folhaPagamentoRepository.findById(IdFolhaPagamento);

        if (resultadoBuscaDaFolha.isEmpty()) {
            throw new IllegalArgumentException("Folha de pagamento com ID especificado não encontrada");
        }

        return resultadoBuscaDaFolha.get();
    }

    public SalarioDescontado BuscarSalarioDescontado(long IdSalarioDescontado) {
        Optional<SalarioDescontado> resultadoBuscaSalarioDescontado =
                salarioDescontadoRepository.findById(IdSalarioDescontado);

        if (resultadoBuscaSalarioDescontado.isEmpty()) {
            throw new IllegalArgumentException("Salário com desconto não encontrado");
        }

        return resultadoBuscaSalarioDescontado.get();
    }
    public SalarioDescontado BuscarSalarioDescontadoPorFuncionario(long IdFuncionario) {

        Optional<SalarioDescontado> resultadoDaBusca =
                salarioDescontadoRepository.findById_funcionario(IdFuncionario);

        if (resultadoDaBusca.isEmpty()) {
            throw new IllegalArgumentException("Nenhum resultado para essa busca. Confirme o ID do funcionário");
        }

        return resultadoDaBusca.get();
    }

    public Beneficios BuscarBeneficioPorFuncionario(long IdFuncionario) {
        Optional<Beneficios> ResultadoDaBuscaDeBeneficioPorFuncionario =
                beneficiosRepository.findById_funcionario(IdFuncionario);
        if(ResultadoDaBuscaDeBeneficioPorFuncionario.isEmpty()){
            throw new IllegalArgumentException("nenhum resultado para a busca de beneficio por funcionario encontrado");
        }
        return ResultadoDaBuscaDeBeneficioPorFuncionario.get();
    }

    public FolhaDePagamento BuscarFolhaDePagamentoPorFuncionario(long IdFuncionario){
        Optional<FolhaDePagamento> ResultadoDaBuscaDaFolhaPorFuncionario =
                folhaPagamentoRepository.findById_funcionario(IdFuncionario);
        if(ResultadoDaBuscaDaFolhaPorFuncionario.isEmpty()){
            throw  new IllegalArgumentException("resultado da busca de folha de pagamento feito pelo id do funcionario" +
                    "nao encontrado");
        }
        return ResultadoDaBuscaDaFolhaPorFuncionario.get();
    }
}
