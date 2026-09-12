package com.treinando_classes.demo.RH.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.treinando_classes.demo.RH.FeriasAtestadosAfastamentos.models.Ferias;
public interface FeriasRepository extends JpaRepository<Ferias, Long>{
}
