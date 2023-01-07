package com.neki.projeto.nekiproject.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@SequenceGenerator(schema = "teste_residencia", name = "generator_skill", sequenceName = "skill_seq", initialValue = 100, allocationSize = 1)
@Table(name = "skill", schema = "teste_residencia")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_skill")
    private Integer id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = true, length = 10)
    private String version;

    @Column(length = 255)
    private String description;

    @Column(length = 255)
    private String image_url;

    @ManyToMany(mappedBy = "skill")
    @JsonBackReference
    private List<Pessoa> pessoa = new ArrayList<Pessoa>();

    public Skill() {

    }

    public Skill(Integer id, String name, String version, String description, String image_url, List<Pessoa> pessoas) {
        this.id = id;
        this.name = name;
        this.version = version;
        this.description = description;
        this.image_url = image_url;

    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage_url() {
        return this.image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public List<Pessoa> getPessoa() {
        return this.pessoa;
    }

    public void setPessoa(List<Pessoa> pessoa) {
        this.pessoa = pessoa;
    }

}
