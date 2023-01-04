package com.neki.projeto.nekiproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neki.projeto.nekiproject.model.Pessoa_Skill;

@Repository
public interface Pessoa_SkillRepository extends JpaRepository<Pessoa_Skill, Integer> {
    
}
