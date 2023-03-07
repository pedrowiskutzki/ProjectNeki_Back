package com.neki.projeto.nekiproject.DTO;

import com.neki.projeto.nekiproject.model.Pessoa_Skill;

public class UpdateLevel_PessoaSkillDTO {

  private Integer knowledge_level;

  public UpdateLevel_PessoaSkillDTO() {

  }

  public UpdateLevel_PessoaSkillDTO(
      Integer knowledge_level) {
    this.knowledge_level = knowledge_level;
  }

  public UpdateLevel_PessoaSkillDTO(Pessoa_Skill Pessoa_Skill) {
    knowledge_level = Pessoa_Skill.getKnowledge_level();

  }

  public Integer getKnowledge_level() {
    return this.knowledge_level;
  }

  public void setKnowledge_level(Integer knowledge_level) {
    this.knowledge_level = knowledge_level;
  }
}
