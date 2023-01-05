package com.neki.projeto.nekiproject.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.jaxb.PageAdapter;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.neki.projeto.nekiproject.DTO.Pessoa_SkillDTO;
import com.neki.projeto.nekiproject.exception.ResourceBadRequestException;
import com.neki.projeto.nekiproject.exception.ResourceNotFoundException;
import com.neki.projeto.nekiproject.model.Pessoa_Skill;
import com.neki.projeto.nekiproject.repository.Pessoa_SkillRepository;

@Service
public class Pessoa_SkillService {

    
    @Autowired
    private Pessoa_SkillRepository pessoa_SkillRepositorio;

	@Transactional
    public List<Pessoa_SkillDTO> obterTodos(){
        return pessoa_SkillRepositorio.findAll().stream().map(Pessoa_SkillDTO:: new).collect(Collectors.toList());
    }

	@Transactional
    public Pessoa_SkillDTO obterPorId(Integer id) {
		Optional<Pessoa_Skill> optPessoa_Skill = pessoa_SkillRepositorio.findById(id);

		if (optPessoa_Skill.isEmpty()) {
			throw new ResourceNotFoundException("Não foi possivel encontrar essa Skill de Usuario com id " + id);
		}
		return new Pessoa_SkillDTO (optPessoa_Skill.get());
	}

	@Transactional
    public Pessoa_SkillDTO cadastrar(Pessoa_Skill pessoa_skill) {

		pessoa_skill = pessoa_SkillRepositorio.saveAndFlush(pessoa_skill);
		pessoa_skill = pessoa_SkillRepositorio.findById(pessoa_skill.getId()).get();
		return new Pessoa_SkillDTO(pessoa_skill);
	}

	

	@Transactional
	public Pessoa_SkillDTO atualizar(Integer id, Pessoa_SkillDTO Pessoa_SkillDTO) {
		try {
			Pessoa_Skill entity = 
			pessoa_SkillRepositorio
			.findById(id)
			.orElseThrow(
			  () -> new ResourceNotFoundException("Skill de pessoa nao encontrada")
			);
		  copyDtoToEntity(entity, Pessoa_SkillDTO);
		  entity = pessoa_SkillRepositorio.save(entity);
		  return new Pessoa_SkillDTO(entity);
		} catch (EntityNotFoundException e) {
		  throw new ResourceNotFoundException("Recurso nao encontrado");
		}
	  }

	@Transactional
    public void deletar(Integer id) {
		pessoa_SkillRepositorio.deleteById(id);
	}

	private void copyDtoToEntity(Pessoa_Skill entity, Pessoa_SkillDTO Pessoa_SkillDTO)  {
		entity.setPessoa(Pessoa_SkillDTO.getPessoa());
		entity.setSkill(Pessoa_SkillDTO.getSkill());
		entity.setKnowledge_level(Pessoa_SkillDTO.getKnowledge_level());
		entity.setCreated_at(Pessoa_SkillDTO.getCreated_at());
		entity.setUpdated_at(Pessoa_SkillDTO.getUpdated_at());
			
	  }

	   
}
