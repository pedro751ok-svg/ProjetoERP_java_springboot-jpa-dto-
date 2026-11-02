package com.treinando_classes.demo;
import com.treinando_classes.demo.RH.repositories.ArmazernarCidsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
@Component
public class CidLoader implements CommandLineRunner {

    private final JdbcTemplate jdbc;
    private final ArmazernarCidsRepository repo;

    public CidLoader(JdbcTemplate jdbc, ArmazernarCidsRepository repo) {
        this.jdbc = jdbc;
        this.repo = repo;
    }

    @Override
    public void run(String... args) throws Exception {
        if (repo.count() > 0) return;

        List<String[]> linhas;
        try (var reader = new BufferedReader(new InputStreamReader(
                getClass().getResourceAsStream("/cid10.csv"), StandardCharsets.UTF_8))) {
            linhas = reader.lines()
                    .skip(1)                       // cabeçalho
                    .map(l -> l.split(";", 4))     // código; categoria; descrição; marcador
                    .toList();
        }

        jdbc.batchUpdate(
                "insert into cids_armazenados (numero_cid, categoria, descricao) values (?, ?, ?)",
                linhas, 500,
                (ps, c) -> {
                    ps.setString(1, c[0]);
                    ps.setString(2, c[1]);
                    ps.setString(3, c[2]);
                });
    }
}
