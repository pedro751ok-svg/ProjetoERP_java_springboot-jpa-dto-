package com.treinando_classes.demo.RH.regras_Enums;

public class RegrasDeEnums {
    public enum CargoRh{
        RH_ASSISTENTE,
        RH_ANALISTA,
        RH_GERENTE
    }
    public enum Permissoes{
        CRIAR_SOLICITACAO,
        CANCELAR_SOLICITACAO,
        EXIBIR_SOLICITACAO,

        ACEITAR_SOLICITACAO,
        REJEITAR_SOLICITACAO,

        GERENCIAR_SOLICITACOES,
        HISTORICO_SOLICITACOES,
        LISTAR_SOLICITACOES_PENDENTES,

        GERENCIAR_CID,
        GERENCIAR_AFASTAMENTO,

        GERENCIAR_FUNCIONARIO,
        GERENCIAR_EMPRESA
    }
    public enum status{
        PENDENTE,
        APROVADO,
        REJEITADO,
        ENCAMINHADO_PARA_AFASTAMENTO,
        CANCELADO,
        ENCAMINHADO,
        EXPIRADO
    }

    public enum MeioDeAfastamento{
        ATESTADO,
        AFASTAMENTO_INSS,
        FERIAS,

    }
    public enum TipoInss{
        B31,
        B91,
        B32,
        B92,
        B93
    }

}

