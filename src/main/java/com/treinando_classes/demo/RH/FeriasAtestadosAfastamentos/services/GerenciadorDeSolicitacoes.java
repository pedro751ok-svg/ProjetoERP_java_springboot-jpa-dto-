package com.treinando_classes.demo.RH.FeriasAtestadosAfastamentos.services;
import com.treinando_classes.demo.RH.FeriasAtestadosAfastamentos.models.*;
import com.treinando_classes.demo.RH.regras_Enums.RegrasDeEnums;
import com.treinando_classes.demo.RH.repositories.*;
import com.treinando_classes.demo.RH.Auth.Repository.CadastroRepository;
import com.treinando_classes.demo.Shared.Funcionario;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
@Service
public class GerenciadorDeSolicitacoes {
    private final SolicitacoesRepository repository;
    private final TipoDeSolicitacaoRepository tipodeSolicitacao;
    private final CadastroRepository cadastroRepository;
    private final FeriasRepository feriasRepository;
    private final AtestadoRepository atestadoRepository;
    private final AfastamentoRepository afastamentoRepository;

    public GerenciadorDeSolicitacoes(SolicitacoesRepository repository, TipoDeSolicitacaoRepository tipodeSolicitacao,
                                     CadastroRepository cadastroRepository,
                                     FeriasRepository feriasRepository,
                                     AtestadoRepository atestadoRepository,
                                     AfastamentoRepository afastamentoRepository) {
        this.repository = repository;
        this.tipodeSolicitacao = tipodeSolicitacao;
        this.cadastroRepository = cadastroRepository;
        this.feriasRepository = feriasRepository;
        this.atestadoRepository = atestadoRepository;
        this.afastamentoRepository = afastamentoRepository;
    }

    public Solicitacoes gerenciador(long id_funcionario, long id_tipo, RegrasDeEnums.status status, LocalDate DataInicio, LocalDate DataFim) {
        if (status != RegrasDeEnums.status.PENDENTE) {
            throw new IllegalArgumentException("s1licitção sem status pendente");
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

        Solicitacoes nova_solicitacao = Solicitacoes.builder()
                .id_funcionario(funcionarioEncontrado)
                .id_tipo(tipoEncontrado)
                .status(status)
                .DataInicio(DataInicio)
                .DataFim(DataFim)
                .build();

        repository.save(nova_solicitacao);
        _criar_registro_filho(tipoEncontrado.getTipo(),nova_solicitacao);
        return nova_solicitacao;

    }
    private void _criar_registro_filho(RegrasDeEnums.MeioDeAfastamento tipo, Solicitacoes id_solicitacao ){
        if (tipo == RegrasDeEnums.MeioDeAfastamento.FERIAS) {
            Ferias ferias = Ferias.builder()
                    .solicitacao_id(id_solicitacao)
                    .build();
            feriasRepository.save(ferias);
        }
        if(tipo == RegrasDeEnums.MeioDeAfastamento.ATESTADO){
            Atestado atestado = Atestado.builder()
                    .solicitacao_id(id_solicitacao)
                    .build();
           atestadoRepository.save(atestado);
        }
        if(tipo == RegrasDeEnums.MeioDeAfastamento.AFASTAMENTO_INSS){
            Afastamento afastamento = Afastamento.builder()
                    .id_solicitacoes(id_solicitacao)
                    .build();
            afastamentoRepository.save(afastamento);
        }
    }


}
