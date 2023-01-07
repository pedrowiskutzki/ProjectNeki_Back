package com.neki.projeto.nekiproject.security;

import java.util.Date;
import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.neki.projeto.nekiproject.model.Pessoa;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTService {

   
    private static final String chavePrivadaJWT = "secretkey";

    /**
     * Metodo para gerar o toke JWT
     * @param authentication Autenticação do usuário
     * @return Token 
     */

    public String gerarToken(Authentication authentication){

        int tempoExpiracao = 864000000;

        Date dataExpiracao = new Date(new Date().getTime() + tempoExpiracao);

        Pessoa pessoa = (Pessoa) authentication.getPrincipal();

        return Jwts.builder()
        .setSubject(pessoa.getId().toString())
        .setIssuedAt(new Date())
        .setExpiration(dataExpiracao)
        .signWith(SignatureAlgorithm.HS512, chavePrivadaJWT)
        .compact();
    }    

/**
 * Metodo para retornar 
 * @param token token do usuário
 * @return id do usuário
 */

    public Optional<Integer> obterId(String token){

        try {
            Claims claims = parse(token).getBody();

            return Optional.ofNullable(Integer.parseInt(claims.getSubject()));

        } catch (Exception e) {
            return Optional.empty();
        }
    }

    private Jws<Claims> parse(String token) {
        return Jwts.parser().setSigningKey(chavePrivadaJWT).parseClaimsJws(token);
    }
}
