package com.neki.projeto.nekiproject.security;

import java.util.Arrays;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.neki.projeto.nekiproject.model.Pessoa;


public class CustomUsernamePasswordAuthenticationToken extends UsernamePasswordAuthenticationToken implements UserDetails{
	private static final long serialVersionUID = 1L;

	private Pessoa user;

	public CustomUsernamePasswordAuthenticationToken(String username, String password, Pessoa user) {
		super(username, password, Arrays.asList(new SimpleGrantedAuthority("USER")));
		this.user = user;
		
		
	}

	public Pessoa getUser() {
		return this.user;
	}

	public void setUser(Pessoa user) {
		this.user = user;
	}

	@Override
	public String getPassword() {
		return null;
	}

	@Override
	public String getUsername() {
		return user.getLogin();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	

	
	
	

}
