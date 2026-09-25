package com.treinando_classes.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CargoRepository extends JpaRepository<DefinirCargos, Long> {
    Optional<DefinirCargos>findById(long id);
}
