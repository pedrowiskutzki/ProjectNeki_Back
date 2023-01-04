package com.neki.projeto.nekiproject.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "user_skill" , schema = "teste_residencia" )
public class Pessoa_Skill{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private Pessoa pessoa_id;
    
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "skill_id")
    private Skill skill_id;

    @Column(nullable = false)
    @NotBlank(message = "Insira o nivel de  1 a 10")
    private Integer knowledge_level;

    @Column(nullable = false)
    @CreationTimestamp
    @JsonFormat(pattern="dd/MM/yyyy HH:mm:ss")
    private LocalDateTime created_at ;

    @Column(nullable = true)
    @UpdateTimestamp
    @JsonFormat(pattern="dd/MM/yyyy HH:mm:ss")
    private LocalDateTime updated_at ;


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pessoa getPessoa_id() {
        return this.pessoa_id;
    }

    public void setPessoa_id(Pessoa pessoa_id) {
        this.pessoa_id = pessoa_id;
    }

    public Skill getSkill_id() {
        return this.skill_id;
    }

    public void setSkill_id(Skill skill_id) {
        this.skill_id = skill_id;
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

