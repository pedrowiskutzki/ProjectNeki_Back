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

    //chave secreta utilizada pelo JWT para codificar e decodificar o token
    private static final String chavePrivadaJWT = "secretkey";

    /**
     * Metodo para gerar o toke JWT
     * @param authentication Autenticação do usuário
     * @return Token 
     */

    public String gerarToken(Authentication authentication){

        //um dia em milisegundo (cada segundo é 1000 milisegundo)
        // o tempo varia de acordo com a regra de negócio
        int tempoExpiracao = 864000000;

        //criando data de expiração somando a data atual mais os milisegndos
        Date dataExpiracao = new Date(new Date().getTime() + tempoExpiracao);

        //pegamos o usuário atual da autenticação
        Pessoa pessoa = (Pessoa) authentication.getPrincipal();

        //Aqui pega todos os dados e retorna um token do jwt
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
            //retorna as permissões do token
            Claims claims = parse(token).getBody();
            //retorna o id de dentro do token se entrar, caso contrário retorna null
            return Optional.ofNullable(Integer.parseInt(claims.getSubject()));

        } catch (Exception e) {
            //se não encontrar nada, devolve optional null
            return Optional.empty();
        }
    }

    //metodo que descobre dentro do token, com base na chave privada, as permissões do usuário
    private Jws<Claims> parse(String token) {
        return Jwts.parser().setSigningKey(chavePrivadaJWT).parseClaimsJws(token);
    }
}
