package com.neki.projeto.nekiproject.DTO;

import java.util.Date;

import com.neki.projeto.nekiproject.model.Pessoa;
import com.neki.projeto.nekiproject.model.Pessoa_Skill;
import com.neki.projeto.nekiproject.model.Skill;

public class Pessoa_SkillDTO {
    
    private Integer id;
    private Pessoa pessoa;
    private Skill skill;
    private Integer knowledge_level;
    private Date created_at;
    private Date updated_at ;

    public Pessoa_SkillDTO(){

    }
    public Pessoa_SkillDTO(
        Integer id,
        Pessoa pessoa,
        Skill skill,
        Integer knowledge_level,
        Date created_at,
        Date updated_at
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

    public Date getCreated_at() {
        return this.created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return this.updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }


}
