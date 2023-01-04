package com.neki.projeto.nekiproject.DTO;

import java.util.Date;

import org.springframework.security.core.userdetails.UserDetails;

import com.neki.projeto.nekiproject.model.Pessoa;

public class PessoaDTO {
    
    private Integer id;
    private String login;
    private String password;
    private Date last_login_date;

public PessoaDTO() {}

public PessoaDTO(
    Integer id,
    String login,
    String password,
    Date last_login_date

){
    this.id= id;
    this.login = login;
    this.password = password;
    this.last_login_date = last_login_date;
}

public PessoaDTO(Pessoa pessoa){
    id = pessoa.getId();
    login = pessoa.getLogin();
    password = pessoa.getPassword();
    last_login_date = pessoa.getLast_login_date();
    }


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLast_login_date() {
        return this.last_login_date;
    }

    public void setLast_login_date(Date last_login_date) {
        this.last_login_date = last_login_date;
    }
   


}