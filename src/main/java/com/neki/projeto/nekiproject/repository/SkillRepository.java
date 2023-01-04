package com.neki.projeto.nekiproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neki.projeto.nekiproject.model.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer> {
    
}
