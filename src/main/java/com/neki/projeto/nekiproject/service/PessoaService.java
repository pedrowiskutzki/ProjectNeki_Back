package com.neki.projeto.nekiproject.service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.neki.projeto.nekiproject.DTO.PessoaDTO;
import com.neki.projeto.nekiproject.exception.ResourceNotFoundException;
import com.neki.projeto.nekiproject.model.Pessoa;
import com.neki.projeto.nekiproject.repository.PessoaRepository;


@Service
public class PessoaService {
    
    @Autowired
    private PessoaRepository pessoaRepositorio;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	

    public List<PessoaDTO> obterTodos(){
        return pessoaRepositorio.findAll().stream().map(PessoaDTO:: new).collect(Collectors.toList());
    }

    public PessoaDTO obterPorId(Integer id) {
		Optional<Pessoa> optPessoa = pessoaRepositorio.findById(id);

		if (optPessoa.isEmpty()) {
			throw new ResourceNotFoundException("Não foi possivel encontrar a pessoa com id " + id);
		}
		return new PessoaDTO(optPessoa.get());
	}
	public Pessoa obterPessoaPorId(Integer id) {
		Optional<Pessoa> optPessoa = pessoaRepositorio.findById(id);

		if (optPessoa.isEmpty()) {
			throw new ResourceNotFoundException("Não foi possivel encontrar a pessoa com id " + id);
		}
		return optPessoa.get();
	}

	public Optional<Pessoa> obterPorLogin(String login){
			return pessoaRepositorio.findByLogin(login);
	}

    public PessoaDTO cadastrar(Pessoa pessoa) {
		pessoa.setId(null);
		
		String password = passwordEncoder.encode(pessoa.getPassword());
		pessoa.setPassword(password);

		return new PessoaDTO(pessoaRepositorio.save(pessoa));
	}

	public PessoaDTO atualizar(Integer id, PessoaDTO PessoaDto) {
		try {
			Pessoa entity = pessoaRepositorio
			.findById(id)
			.orElseThrow(
			  () -> new ResourceNotFoundException("Pessoa nao encontrada")
			);
		  copyDtoToEntity(entity, PessoaDto);
		  entity = pessoaRepositorio.save(entity);
		  return new PessoaDTO(entity);
		} catch (EntityNotFoundException e) {
		  throw new ResourceNotFoundException("Pessoa nao encontrada");
		}
	  }

    public void deletar(Integer id) {
		pessoaRepositorio.deleteById(id);
	}

	private void copyDtoToEntity(Pessoa entity, PessoaDTO PessoaDto)  {
		entity.setLogin(PessoaDto.getLogin());
		entity.setPassword(PessoaDto.getPassword());
		entity.setLast_login_date(PessoaDto.getLast_login_date());
	}

	
}
