package com.neki.projeto.nekiproject.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.neki.projeto.nekiproject.service.PessoaService;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    
    @Autowired
    private PessoaService pessoaService;

    public UserDetails loadUserByUsername (String login) {
        return pessoaService.obterPorLogin(login).get();    
    
    }

    public UserDetails obterPessoaPorId (Integer id) {
        return pessoaService.obterPessoaPorId(id);
    }

}
