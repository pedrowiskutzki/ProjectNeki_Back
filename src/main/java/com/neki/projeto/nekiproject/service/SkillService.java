package com.neki.projeto.nekiproject.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neki.projeto.nekiproject.DTO.SkillDTO;
import com.neki.projeto.nekiproject.exception.ResourceNotFoundException;
import com.neki.projeto.nekiproject.model.Skill;
import com.neki.projeto.nekiproject.repository.SkillRepository;

@Service
public class SkillService {
    
    @Autowired
    private SkillRepository skillRepositorio;

	public List<SkillDTO> obterTodos(){
        return skillRepositorio.findAll().stream().map(SkillDTO:: new).collect(Collectors.toList());
    }

    public SkillDTO obterPorId(Integer id){
        Optional<Skill> optSkill = skillRepositorio.findById(id);

        if (optSkill.isEmpty()) {
			throw new ResourceNotFoundException("Não foi possivel encontrar a evento com id " + id);
		}
		return new SkillDTO(optSkill.get());
    } 

    public SkillDTO cadastrar(Skill skill) {
		
		return new SkillDTO(skillRepositorio.save(skill));
	}

  public SkillDTO atualizar(Integer id, SkillDTO SkillDTO) {
		try {
			Skill entity = skillRepositorio
			.findById(id)
			.orElseThrow(
			  () -> new ResourceNotFoundException("Skill nao encontrada")
			);
		  copyDtoToEntity(entity, SkillDTO);
		  entity = skillRepositorio.save(entity);
		  return new SkillDTO(entity);
		} catch (EntityNotFoundException e) {
		  throw new ResourceNotFoundException("Recurso nao encontrado");
		}
	  }

    public void deletar(Integer id) {
		skillRepositorio.deleteById(id);
	}

  private void copyDtoToEntity(Skill skill, SkillDTO SkillDTO)  {
    skill.setId(SkillDTO.getId());
    skill.setName(SkillDTO.getName());
    skill.setVersion(SkillDTO.getVersion());
    skill.setDescription(SkillDTO.getDescription());
    skill.setImage_url(SkillDTO.getImage_url());

    }

    
}



