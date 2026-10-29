package com.treinando_classes.demo.Services_token_generated;

import io.jsonwebtoken.io.SerialException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.UserDetailsManagerConfigurer;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
//uso componente e OncePerRequesteFilter , é uma classe base do Spring que garante-
// que o filtro roda uma vez por requisição.
@Component
public class JwtFilter extends OncePerRequestFilter{
    private final TokenGenerated tokenGenerated;
    private final UserDetailsService userDetailsService;

    public JwtFilter(TokenGenerated tokenGenerated, UserDetailsService userDetailsService){
        this.tokenGenerated = tokenGenerated;
        this.userDetailsService = userDetailsService;
    }
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain)
        throws ServletException,IOException {
            String header = request.getHeader("Authorization");

            if (header != null && header.startsWith("Bearer ")) {
                String token = header.substring(7);

                if (tokenGenerated.ValidarToken(token) && SecurityContextHolder.getContext().getAuthentication() == null) {
                    String username = tokenGenerated.extrairUserName(token);
                    UserDetails user = userDetailsService.loadUserByUsername(username);

                    UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(user, null,
                            user.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(auth);


                }
            }
        chain.doFilter(request, response);
        }
    }



