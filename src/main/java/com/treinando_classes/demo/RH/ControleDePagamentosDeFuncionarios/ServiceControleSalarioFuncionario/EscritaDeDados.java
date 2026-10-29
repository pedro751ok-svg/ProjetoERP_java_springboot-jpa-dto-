package com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.ServiceControleSalarioFuncionario;

import com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Domain.EnumBeneficios;
import com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Model.Beneficios;
import com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Repository.BeneficiosRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class EscritaDeDados {
    private final BeneficiosRepository beneficiosRepository;

    public EscritaDeDados(BeneficiosRepository beneficiosRepository) {
        this.beneficiosRepository = beneficiosRepository;
    }


    @Transactional
    public Beneficios AtualizarBeneficio(long IdBeneficio, EnumBeneficios.Periodicidade Periodicidade, BigDecimal ValorDoBeneficio,
                                         String Fornecedor, EnumBeneficios.Tipo_De_Calculo TipoDeCalculo, boolean Ativo) {
        Optional<Beneficios> BuscandoBeneficio = beneficiosRepository.findById(IdBeneficio);
        if (BuscandoBeneficio.isEmpty()) {
            throw new IllegalArgumentException("Nenhum benefício com esse ID encontrado");
        }
        if (ValorDoBeneficio == null || ValorDoBeneficio.signum() <= 0) {
            throw new IllegalArgumentException("o valor do beneficio deve ser maior que zero");
        }
        if (Periodicidade == null) {
            throw new IllegalArgumentException("a periodicidade do beneficio nao pode ser nula");
        }
        Beneficios beneficio = BuscandoBeneficio.get();
        beneficio.setPeriodicidade(Periodicidade);
        beneficio.setValorDoBeneficio(ValorDoBeneficio);
        beneficio.setFornecedor(Fornecedor);
        beneficio.setTipoDeCalculo(TipoDeCalculo);
        beneficio.setAtivo(Ativo);
        return beneficiosRepository.save(beneficio);
    }

    @Transactional
    public void RemoverBeneficio(long IdBeneficio) {
        Optional<Beneficios> BuscandoBeneficio = beneficiosRepository.findById(IdBeneficio);
        if (BuscandoBeneficio.isEmpty()) {
            throw new IllegalArgumentException("Nenhum benefício com esse ID encontrado");
        }
        beneficiosRepository.delete(BuscandoBeneficio.get());
    }
}