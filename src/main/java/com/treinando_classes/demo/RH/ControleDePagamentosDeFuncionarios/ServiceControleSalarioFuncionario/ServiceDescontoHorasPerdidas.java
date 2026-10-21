package com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.ServiceControleSalarioFuncionario;

import com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Domain.DescontoHoras;
import com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Model.FolhaDePagamento;
import com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Model.SalarioDescontado;
import com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Repository.FolhaPagamentoRepository;
import com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Repository.SalarioDescontadoRepository;
import org.hibernate.dialect.unique.CreateTableUniqueDelegate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

@Service
public class ServiceDescontoHorasPerdidas {
    private final SalarioDescontadoRepository repository;
    private final FolhaPagamentoRepository folhaPagamentoRepository;

    public ServiceDescontoHorasPerdidas(SalarioDescontadoRepository repository,
                                        FolhaPagamentoRepository folhaPagamentoRepository){
        this.repository = repository;
        this.folhaPagamentoRepository = folhaPagamentoRepository;
    }

    public FolhaDePagamento Buscar_folha(long IdFolhaDePagamento){
        Optional<FolhaDePagamento> Resultado_Busca_Folha = folhaPagamentoRepository.findById(IdFolhaDePagamento);
        if(Resultado_Busca_Folha.isEmpty()){
            throw new IllegalArgumentException("nenhuma folha encontrtada");
        }
        return Resultado_Busca_Folha.get();
    }

    @Transactional
    public BigDecimal definir_descontos(long IdFolhaDePagamento){
        FolhaDePagamento desconto_folha = Buscar_folha(IdFolhaDePagamento);
        BigDecimal ValorPorHora = desconto_folha.getValorGanhoPorHora();
        BigDecimal ValorDesconto = desconto_folha.getHorasFaltantes();
        BigDecimal DescontoAplicado = new DescontoHoras().descontos_horas(ValorPorHora,ValorDesconto);
        return DescontoAplicado;
    }

    public SalarioDescontado desconto(long IdFolhaDePagamento ){
        FolhaDePagamento folha = Buscar_folha(IdFolhaDePagamento);
        BigDecimal salario = folha.getSalario();

        BigDecimal HorasPerdidas = folha.getHorasFaltantes();
        BigDecimal ValorDesconto = folha.getValorGanhoPorHora();
        BigDecimal DescontoTotal= new DescontoHoras().descontos_horas(HorasPerdidas,ValorDesconto);

        BigDecimal liquido = AplicarDesconto(salario , DescontoTotal);

        SalarioDescontado registro = new SalarioDescontado();
        registro.setId_FolhaDePagamento(folha);
        registro.setId_funcionario(folha.getId_funcionario());
        registro.setTotal_horas(DescontoTotal);

        return repository.save(registro);
    }

    private BigDecimal AplicarDesconto(BigDecimal salario, BigDecimal ValorDesconto){

        if (ValorDesconto.compareTo(salario) > 0) {
            throw new IllegalArgumentException("O desconto não pode ser maior que o salário");
        }
        return salario.subtract(ValorDesconto).setScale(2, RoundingMode.HALF_UP);

    }
}
