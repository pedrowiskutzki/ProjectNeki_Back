package com.neki.projeto.nekiproject.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;



@Entity
@SequenceGenerator(schema = "teste_residencia", name = "generator_user", sequenceName = "user_seq", initialValue = 100, allocationSize = 1)
@Table(name = "user" , schema = "teste_residencia")
public class Pessoa implements UserDetails {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_user" )
    private Integer id;

    @Column(nullable = false, length = 12)
    private String login;

    @Column(nullable = false, length = 100)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @UpdateTimestamp
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date last_login_date;

    @ManyToMany
    @JoinTable(name = "user_skill",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name="skillId"))
    private List<Skill> skill = new ArrayList<Skill>();

    
    public Pessoa() {
    }

    public Pessoa(Integer id, String login, String password, Date last_login_date, List<Skill> skill) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.last_login_date = last_login_date;

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

    public List<Skill> getSkill() {
        return this.skill;
    }

    public void setSkill(List<Skill> skill) {
        this.skill = skill;
    }
   

    //Daqui pra baixo é implementação de UserDetails

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        
        return Arrays.asList(new SimpleGrantedAuthority("USER"));

    }

    @JsonIgnore
    public String getPassword1() {
        return password;
    }

    @Override
    @JsonIgnore
    public String getUsername() {
        return login;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
       return true;
    }



}
