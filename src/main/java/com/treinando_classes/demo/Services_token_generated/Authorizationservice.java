package com.treinando_classes.demo.Services_token_generated;

import com.treinando_classes.demo.RH.Auth.Repository.CadastroRepository;
import com.treinando_classes.demo.Shared.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class Authorizationservice implements UserDetailsService {
    @Autowired
    CadastroRepository repository;
    @Override
    public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {
       Funcionario f = repository.findFirstByCpf(cpf).orElseThrow(() -> new UsernameNotFoundException("funcionario nao encontrado"));


        return org.springframework.security.core.userdetails.User
                .withUsername(f.getCpf())
                .password(f.getSenha())
                .authorities("ROLE_USER")
                .build();
    }
}
