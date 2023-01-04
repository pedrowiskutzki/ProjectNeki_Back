package com.neki.projeto.nekiproject.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.neki.projeto.nekiproject.model.Pessoa;
import com.neki.projeto.nekiproject.repository.PessoaRepository;
import com.neki.projeto.nekiproject.security.JWTService;
import com.neki.projeto.nekiproject.view.model.pessoaLogin.LoginResponse;


@Service
public class LoginService{

    @Autowired
    private PessoaRepository pessoaRepositorio;

    @Autowired
	private JWTService jwtService;

	@Autowired
	private AuthenticationManager authenticationManager;



public LoginResponse logar(String login, String senha){

    Authentication autenticacao = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(login, senha));

    SecurityContextHolder.getContext().setAuthentication(autenticacao);

    String token = jwtService.gerarToken(autenticacao);

    Pessoa pessoa = pessoaRepositorio.findByLogin(login).get();

    return new LoginResponse(token, pessoa);

}
}