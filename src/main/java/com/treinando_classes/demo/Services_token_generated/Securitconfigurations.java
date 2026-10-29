package com.treinando_classes.demo.Services_token_generated;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
public class Securitconfigurations {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(autorize -> autorize
                        .requestMatchers("auth**" ).permitAll()
                        .requestMatchers("rh-registrar-funcionario**").hasAnyRole("RH_ANALISTA","RH_GERENTE","RH_ASSISTENTE")
                        .requestMatchers("rh-registrar-asalariado**").hasAnyRole("RH_ANALISTA","RH_ASSISTENTE")
                        .requestMatchers("rh-registrar-beneficio**").hasRole("RH_GERENTE")
                        .requestMatchers("rh-atualizar-beneficio**").hasRole("RH_ANALISTA")
                        .requestMatchers("rh-remover-beneficio**").hasRole("RH_GERENTE")
                        .requestMatchers("rh-buscar-folha-de-paghamento-por-data**").hasAnyRole("RH_ANALISTA","RH_ASSISTENTE")
                        .requestMatchers("rh-listar-beneficios-do-funcionario**").hasAnyRole("RH_ANALISTA","RH_ASSISTENTE")
                        .requestMatchers("rh-listar-descontos-de-salarios-do-funcionario**").hasAnyRole("RH_ANALISTA","RH_ASSISTENTE")
                        .requestMatchers("rh-listar-beneficios-ativos").hasAnyRole("RH_ANALISTA","RH_ASSISTENTE")
                        .requestMatchers("rh-buscar_folha-de-pagamento-por-funcionario**").hasAnyRole("RH_ANALISTA","RH_ASSISTENTE")
                        .requestMatchers("rh-buscar-salario-descontado-do-funcionario**").hasAnyRole("RH_ANALISTA","RH_ASSISTENTE")
                        .requestMatchers("rh-buscar-folha-de-pagamento**").hasAnyRole("RH_ANALISTA","RH_ASSISTENTE")
                        .requestMatchers("rh-buscar-beneficio**").hasAnyRole("RH_ANALISTA","RH_ASSISTENTE")
                        .requestMatchers("rh**").hasRole("RH_GERENTE")
                        .anyRequest().authenticated())
                .build();
    }
}

