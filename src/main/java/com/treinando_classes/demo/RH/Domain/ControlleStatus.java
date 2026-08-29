package com.treinando_classes.demo.RH.Domain;
import com.treinando_classes.demo.RH.regras_Enums.RegrasDeEnums;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.Set;
public class ControlleStatus {
    public static final Map<RegrasDeEnums.CargoRh, Set<RegrasDeEnums.Permissoes>> PERMISSOES =
            new EnumMap<>(RegrasDeEnums.CargoRh.class);
    static{
    PERMISSOES.put(RegrasDeEnums.CargoRh.RH_ASSISTENTE, EnumSet.of(
            RegrasDeEnums.Permissoes.CRIAR_SOLICITACAO,
            RegrasDeEnums.Permissoes.CANCELAR_SOLICITACAO,
            RegrasDeEnums.Permissoes.EXIBIR_SOLICITACAO
    ));

    PERMISSOES.put(RegrasDeEnums.CargoRh.RH_ANALISTA, EnumSet.of(
            RegrasDeEnums.Permissoes.CRIAR_SOLICITACAO,
            RegrasDeEnums.Permissoes.CANCELAR_SOLICITACAO,
            RegrasDeEnums.Permissoes.EXIBIR_SOLICITACAO,
            RegrasDeEnums.Permissoes.ACEITAR_SOLICITACAO,
            RegrasDeEnums.Permissoes.REJEITAR_SOLICITACAO,
            RegrasDeEnums.Permissoes.GERENCIAR_AFASTAMENTO,
            RegrasDeEnums.Permissoes.GERENCIAR_CID
    ));
    PERMISSOES.put(RegrasDeEnums.CargoRh.RH_GERENTE, EnumSet.of(

            RegrasDeEnums.Permissoes.CRIAR_SOLICITACAO,
            RegrasDeEnums.Permissoes.CANCELAR_SOLICITACAO,
            RegrasDeEnums.Permissoes.EXIBIR_SOLICITACAO,
            RegrasDeEnums.Permissoes.ACEITAR_SOLICITACAO,
            RegrasDeEnums.Permissoes.REJEITAR_SOLICITACAO,
            RegrasDeEnums.Permissoes.GERENCIAR_AFASTAMENTO,
            RegrasDeEnums.Permissoes.GERENCIAR_CID,
            RegrasDeEnums.Permissoes.GERENCIAR_SOLICITACOES,
            RegrasDeEnums.Permissoes.GERENCIAR_EMPRESA,
            RegrasDeEnums.Permissoes.HISTORICO_SOLICITACOES,
            RegrasDeEnums.Permissoes.LISTAR_SOLICITACOES_PENDENTES,
            RegrasDeEnums.Permissoes.GERENCIAR_FUNCIONARIO
    ));

        }
    public static Boolean controlledeacesso(RegrasDeEnums.CargoRh role, RegrasDeEnums.Permissoes permissao){
        return PERMISSOES.getOrDefault(role, Set.of()).contains(permissao);
    }
}
