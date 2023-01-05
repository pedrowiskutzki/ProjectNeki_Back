package com.neki.projeto.nekiproject.DTO;

import java.time.LocalDateTime;

import com.neki.projeto.nekiproject.model.Pessoa;
import com.neki.projeto.nekiproject.model.Pessoa_Skill;
import com.neki.projeto.nekiproject.model.Skill;

public class Pessoa_SkillDTO {
    
    private Integer id;
    private Pessoa pessoa;
    private Skill skill;
    private Integer knowledge_level;
    private LocalDateTime created_at;
    private LocalDateTime updated_at ;

    public Pessoa_SkillDTO(){

    }
    public Pessoa_SkillDTO(
        Integer id,
        Pessoa pessoa,
        Skill skill,
        Integer knowledge_level,
        LocalDateTime created_at,
        LocalDateTime updated_at
    ){
        this.id = id;
        this.pessoa = pessoa;
        this.skill = skill;
        this.knowledge_level = knowledge_level;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Pessoa_SkillDTO(Pessoa_Skill Pessoa_Skill){
        id = Pessoa_Skill.getId();
        pessoa = Pessoa_Skill.getPessoa();
        skill = Pessoa_Skill.getSkill();
        knowledge_level = Pessoa_Skill.getKnowledge_level();
        created_at = Pessoa_Skill.getCreated_at();
        updated_at = Pessoa_Skill.getUpdated_at();

    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public Pessoa getPessoa() {
        return this.pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Skill getSkill() {
        return this.skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public Integer getKnowledge_level() {
        return this.knowledge_level;
    }

    public void setKnowledge_level(Integer knowledge_level) {
        this.knowledge_level = knowledge_level;
    }

    public LocalDateTime getCreated_at() {
        return this.created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return this.updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }


}
