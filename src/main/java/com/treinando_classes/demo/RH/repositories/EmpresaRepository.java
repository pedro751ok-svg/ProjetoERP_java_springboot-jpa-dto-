package com.treinando_classes.demo.RH.repositories;
import com.treinando_classes.demo.Shared.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmpresaRepository extends JpaRepository<Empresa, Long > {
    boolean existsByCnpj(String Cnpj);
    boolean existsByEmailCorporativo( String email_corporativo);

    Optional<Empresa> findByCnpj(String cnpj);

}
