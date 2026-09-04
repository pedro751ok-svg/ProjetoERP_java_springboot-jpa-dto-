
package com.treinando_classes.demo.RH.repositories;

import com.treinando_classes.demo.Shared.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CadastroRepository extends JpaRepository<Funcionario,Long > {
    boolean existByCpf(String cpf);
    boolean existByEmail(String email);
    Optional<Funcionario>findFirstByCpf(String cpf);
}