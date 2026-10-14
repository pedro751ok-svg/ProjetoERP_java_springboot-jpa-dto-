package com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.ServiceControleSalarioFuncionario;

import com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Model.Beneficios;
import com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Model.FolhaDePagamento;
import com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Model.SalarioDescontado;
import com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Repository.BeneficiosRepository;
import com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Repository.FolhaPagamentoRepository;
import com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Repository.SalarioDescontadoRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;
@Service

public class DescontoValeTransporteFuncionario {

    private final BeneficiosRepository repository;
    private final FolhaPagamentoRepository folhaPagamentoRepository;
    private final SalarioDescontadoRepository salarioDescontadoRepository;

    public DescontoValeTransporteFuncionario(BeneficiosRepository repository,
                                             FolhaPagamentoRepository folhaPagamentoRepository,
                                             SalarioDescontadoRepository salarioDescontadoRepository){
        this.repository = repository;
        this.folhaPagamentoRepository = folhaPagamentoRepository;
        this.salarioDescontadoRepository = salarioDescontadoRepository;
    }
    public Beneficios beneficios( long Id_Beneficio){
        Optional<Beneficios> Buscarbeneficios = repository.findById(Id_Beneficio);

        if(Buscarbeneficios.isEmpty()){
            throw new  IllegalArgumentException("beneficio nao encontrado");
        }
        return Buscarbeneficios.get();
    }
    public FolhaDePagamento folhaDePagamento( long Id_Salario){
        Optional<FolhaDePagamento> Buscarsalario = folhaPagamentoRepository.findById(Id_Salario);

        if(Buscarsalario.isEmpty()){
            throw new IllegalArgumentException("Informações de salario nao encontrada");
        }
        return Buscarsalario.get();
    }
    public SalarioDescontado DescontarVT(long IdFolha, long IdBeneficio){
        FolhaDePagamento folha = folhaDePagamento(IdFolha);
        BigDecimal salario = folha.getSalario();

        Beneficios beneficio = beneficios(IdBeneficio);
        BigDecimal ValorDesconto = beneficio.getValorDoBeneficio();

        BigDecimal liquido = CalcularDesconto(salario , ValorDesconto);
        SalarioDescontado registro = new SalarioDescontado();
        registro.setId_FolhaDePagamento(folha);
        registro.setId_funcionario(folha.getId_funcionario());
        registro.setTotal(liquido);

        return salarioDescontadoRepository.save(registro);
    }
    private BigDecimal CalcularDesconto(BigDecimal salario, BigDecimal ValorDesconto){
        if (ValorDesconto.compareTo(salario) > 0) {
            throw new IllegalArgumentException("O desconto não pode ser maior que o salário");
        }
        return salario.subtract(ValorDesconto);

    }

}
