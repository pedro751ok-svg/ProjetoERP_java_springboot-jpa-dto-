package com.treinando_classes.demo.RH.repositories;
import com.treinando_classes.demo.Shared.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
public interface EmpresaRepository extends JpaRepository<Empresa, Long > {
    boolean existsByCnpj(String Cnpj);
    boolean existsByEmailCorporativo( String email_corporativo);
}
