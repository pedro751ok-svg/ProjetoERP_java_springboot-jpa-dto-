package com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.ServiceControleSalarioFuncionario;

import com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Domain.DescontoConvenio;
import com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Domain.DescontoVT;
import com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Domain.DescontoVr;
import com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Domain.EnumBeneficios;
import com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Model.Beneficios;
import com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Model.FolhaDePagamento;
import com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Model.SalarioDescontado;
import com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Repository.BeneficiosRepository;
import com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Repository.FolhaPagamentoRepository;
import com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Repository.SalarioDescontadoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;
@Service

public class ServiceDescontoTotalBeneficio {

    private final BeneficiosRepository repository;
    private final FolhaPagamentoRepository folhaPagamentoRepository;
    private final SalarioDescontadoRepository salarioDescontadoRepository;

    public ServiceDescontoTotalBeneficio(BeneficiosRepository repository,
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
    public BigDecimal definir_desconto(EnumBeneficios.Tipo_De_Beneficio tipoDeBeneficio,long IdBeneficio){
        if(tipoDeBeneficio == EnumBeneficios.Tipo_De_Beneficio.VT){
            Beneficios beneficio_vt = beneficios(IdBeneficio);
            BigDecimal ValorDesconto = beneficio_vt.getValorDoBeneficio();
            BigDecimal valor_final_desconto_vt  = new DescontoVT().descontoBeneficio(ValorDesconto);
            return valor_final_desconto_vt;

        }
        if( tipoDeBeneficio == EnumBeneficios.Tipo_De_Beneficio.VR){
            Beneficios benficios_Vr = beneficios(IdBeneficio);
            BigDecimal ValorDesconto = benficios_Vr.getValorDoBeneficio();
            BigDecimal valor_final_desconto_vr = new DescontoVr().descontoBeneficio(ValorDesconto);
            return valor_final_desconto_vr;

        }

        if(tipoDeBeneficio == EnumBeneficios.Tipo_De_Beneficio.CONVENIO){
            Beneficios beneficio_convenio = beneficios(IdBeneficio);
            BigDecimal ValorDesconto = beneficio_convenio.getValorDoBeneficio();
            BigDecimal valor_final_desconto_convenio = new DescontoConvenio().descontoBeneficio(ValorDesconto);
            return valor_final_desconto_convenio;
        }
        throw new IllegalArgumentException("tipo do beneficio nao reconhecido" + tipoDeBeneficio);

    }

    @Transactional
    public SalarioDescontado descontar(long idFolha, long idBeneficio) {
        FolhaDePagamento folha = folhaDePagamento(idFolha);
        BigDecimal salario = folha.getSalario();

        Beneficios beneficio = beneficios(idBeneficio);
        BigDecimal valorBeneficio = beneficio.getValorDoBeneficio();
        BigDecimal descontoVt = new DescontoVT().descontoBeneficio(valorBeneficio);

        BigDecimal liquido = AplicarDesconto(salario, descontoVt);

        SalarioDescontado registro = new SalarioDescontado();
        registro.setId_FolhaDePagamento(folha);
        registro.setId_funcionario(folha.getId_funcionario());
        registro.setTotal_beneficio(liquido);

        return salarioDescontadoRepository.save(registro);
    }

    private BigDecimal AplicarDesconto(BigDecimal salario, BigDecimal ValorDesconto){
        if(ValorDesconto == null){
            throw new IllegalArgumentException("os valores nao podem ser nulos");
        }
        if (ValorDesconto.compareTo(salario) > 0) {
            throw new IllegalArgumentException("O desconto não pode ser maior que o salário");
        }
        if(ValorDesconto.signum() < 0 ){
            throw new IllegalArgumentException("o valor do desconto nao pode ser zero");
        }
        if(ValorDesconto.compareTo(salario) > 0 ){
            throw new IllegalArgumentException("o valor do desnconto nao pode ser maior que o salario");
        }
        return salario.subtract(ValorDesconto).setScale(2, RoundingMode.HALF_UP);

    }

}
