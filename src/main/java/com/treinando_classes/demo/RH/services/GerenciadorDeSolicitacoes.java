package com.treinando_classes.demo.RH.services;
import com.treinando_classes.demo.RH.models.Solicitacoes;
import com.treinando_classes.demo.RH.models.TipodeSolicitacao;
import com.treinando_classes.demo.RH.regras_Enums.RegrasDeEnums;
import com.treinando_classes.demo.RH.repositories.SolicitacoesRepository;
import com.treinando_classes.demo.RH.repositories.TipoDeSolicitacaoRepository;
import com.treinando_classes.demo.RH.repositories.CadastroRepository;
import com.treinando_classes.demo.Shared.Funcionario;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
@Service
public class GerenciadorDeSolicitacoes {
    private final SolicitacoesRepository repository;
    private final TipoDeSolicitacaoRepository tipodeSolicitacao;
    private final CadastroRepository cadastroRepository;

    public GerenciadorDeSolicitacoes(SolicitacoesRepository repository, TipoDeSolicitacaoRepository tipodeSolicitacao, CadastroRepository cadastroRepository) {
        this.repository = repository;
        this.tipodeSolicitacao = tipodeSolicitacao;
        this.cadastroRepository = cadastroRepository;
    }

    public Solicitacoes gerenciador(long id_funcionario, long id_tipo, RegrasDeEnums.status status, LocalDate DataInicio, LocalDate DataFim) {
        if (status != RegrasDeEnums.status.PENDENTE) {
            throw new IllegalArgumentException("solicitção sem status pendente");
        }
        if(DataInicio.isAfter(DataFim)){
            throw new IllegalArgumentException("as datas nao condizem uma com a outra");

        }

            Optional<Solicitacoes> solicitacao = repository.
                    findFirstById_funcionario_IdAndId_tipo_IdAndStatusAndDataInicioAndDataFim(
                            id_funcionario,
                            id_tipo,
                            status,
                            DataInicio,
                            DataFim

                    );


            if (solicitacao.isPresent()) {
                throw new IllegalArgumentException("funcionario ja tem uma mesma solicitção feita");
            }

        TipodeSolicitacao tipoEncontrado = tipodeSolicitacao.findById(id_tipo)
                .orElseThrow(() -> new IllegalArgumentException("Tipo de solicitação não encontrado"));

        Funcionario funcionarioEncontrado = cadastroRepository.findById(id_funcionario)
                .orElseThrow(() -> new IllegalArgumentException("funcionario nao encontrado"));

    }
}
