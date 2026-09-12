package com.treinando_classes.demo.RH.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.treinando_classes.demo.RH.FeriasAtestadosAfastamentos.models.Afastamento;
public interface AfastamentoRepository extends JpaRepository<Afastamento, Long> {
}
