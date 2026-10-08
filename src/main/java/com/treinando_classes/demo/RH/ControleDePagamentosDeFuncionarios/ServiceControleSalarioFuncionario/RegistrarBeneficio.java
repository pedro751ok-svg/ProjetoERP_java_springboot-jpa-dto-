package com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.ServiceControleSalarioFuncionario;

import com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Domain.EnumBeneficios;
import com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Model.Beneficios;
import com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Repository.BeneficiosRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;
@Service
public class RegistrarBeneficio {
    private final BeneficiosRepository repository;

    public RegistrarBeneficio(BeneficiosRepository repository) {
        this.repository = repository;
    }

    public Beneficios Registrar(String TipoDeBeneficio, EnumBeneficios.Periodicidade Periodicidade, BigDecimal ValorDoBeneficio,
                                    String Fornecedor, EnumBeneficios.Tipo_De_Calculo TipoDeCalculo) {
        Optional<Beneficios> CadastrandoBeneficio = repository.findByTipoDeBeneficio(TipoDeBeneficio);

        if (CadastrandoBeneficio.isPresent()) {
            throw new IllegalArgumentException("um beneficio desse mesmo tipo ja esta registrado" +
                    "em caso de alteração remova o beneficio antigo primeiro");
        }
        Beneficios novo_beneficio = Beneficios.builder()
                .TipoDeBeneficio(TipoDeBeneficio)
                .Periodicidade(Periodicidade)
                .ValorDoBeneficio(ValorDoBeneficio)
                .Fornecedor(Fornecedor)
                .TipoDeCalculo(TipoDeCalculo)
                .build();

        repository.save(novo_beneficio);
        return novo_beneficio;
    }
    }
