
package com.treinando_classes.demo.RH.repositories;

import com.treinando_classes.demo.Shared.Funcionario;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CadastroRepository extends JpaRepository<Funcionario,Long> {
    boolean existsByCpf(String cpf);
    boolean existsByEmail(String email);

    Optional<Funcionario>findFirstByCpf(String cpf);
}