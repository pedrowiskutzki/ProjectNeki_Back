package com.neki.projeto.nekiproject.DTO;

import com.neki.projeto.nekiproject.model.Skill;

public class SkillDTO {
    
    private Integer id;
    private String name;
    private String version;
    private String description;
    private String image_url;

    public SkillDTO(){

    }
    public SkillDTO(
        Integer id,
        String name,
        String version,
        String description,
        String image_url
    ){
        this.id = id;
        this.name = name;
        this.version = version;
        this.description = description;
        this.image_url = image_url;
    }

    public SkillDTO(Skill skill){
        id = skill.getId();
        name = skill.getName();
        version = skill.getVersion();
        description = skill.getDescription();
        image_url = skill.getImage_url();
        
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



}
