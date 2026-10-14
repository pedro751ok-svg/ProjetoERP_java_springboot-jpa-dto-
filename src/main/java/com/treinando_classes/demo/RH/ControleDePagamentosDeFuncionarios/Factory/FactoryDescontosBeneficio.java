package com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Factory;

import com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Domain.DescontoVT;
import com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Domain.DescontoVr;
import com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Domain.DescontoConvenio;
import com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Interface.DescontoBeneficioInterface;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class FactoryDescontosBeneficio {
    private final Map<String , DescontoBeneficioInterface> map = Map.of(
            "VT", new DescontoVT(),
            "VR", new DescontoVr(),
            "CONVENIO", new DescontoConvenio()
    );
    public DescontoBeneficioInterface get(String tipoDeBeneficio) {
        DescontoBeneficioInterface strategy = map.get(tipoDeBeneficio.toUpperCase());
        if (strategy == null) {
            throw new IllegalArgumentException("Sem regra de desconto para: " + tipoDeBeneficio);
        }
        return strategy;
    }
}

