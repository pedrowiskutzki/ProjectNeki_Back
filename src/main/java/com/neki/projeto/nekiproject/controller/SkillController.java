package com.neki.projeto.nekiproject.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.neki.projeto.nekiproject.DTO.PessoaDTO;
import com.neki.projeto.nekiproject.DTO.SkillDTO;
import com.neki.projeto.nekiproject.model.Pessoa;
import com.neki.projeto.nekiproject.model.Skill;
import com.neki.projeto.nekiproject.service.LoginService;
import com.neki.projeto.nekiproject.service.PessoaService;
import com.neki.projeto.nekiproject.service.SkillService;
import com.neki.projeto.nekiproject.view.model.pessoaLogin.LoginRequest;
import com.neki.projeto.nekiproject.view.model.pessoaLogin.LoginResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/skill")
public class SkillController {

  @Autowired
  private SkillService skillService;

  @GetMapping(value = "/{id}")
  @ApiOperation(value = "Lista dados de skill", notes = "Lista dados de skill")
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Lista dados da skill"),
      @ApiResponse(code = 401, message = "Erro de autenticação"),
      @ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
      @ApiResponse(code = 404, message = "Recurso não encontrado"),
      @ApiResponse(code = 505, message = "Exceção interna da aplicação"),
  })
  public ResponseEntity<SkillDTO> obterPorId(@PathVariable Integer id) {
    SkillDTO dto = skillService.obterPorId(id);
    return ResponseEntity.ok(dto);
  }

  @GetMapping
  @ApiOperation(value = "Lista todas as skills", notes = "Lista todas as skills")
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Lista todas Skills"),
      @ApiResponse(code = 401, message = "Erro de autenticação"),
      @ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
      @ApiResponse(code = 404, message = "Recurso não encontrado"),
      @ApiResponse(code = 505, message = "Exceção interna da aplicação"),
  })
  public ResponseEntity<List<SkillDTO>> obterTodos() {
    List<SkillDTO> dto = skillService.obterTodos();
    return ResponseEntity.ok(dto);
  }

  @PostMapping
  @ApiOperation(value = "Cadastra Skill", notes = "Cadastra Skill")
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Cadastra Skill"),
      @ApiResponse(code = 401, message = "Erro de autenticação"),
      @ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
      @ApiResponse(code = 404, message = "Recurso não encontrado"),
      @ApiResponse(code = 505, message = "Exceção interna da aplicação"),
  })
  public ResponseEntity<SkillDTO> cadastrar(@Valid @RequestBody Skill skill) {
    SkillDTO dto = skillService.cadastrar(skill);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
    return ResponseEntity.created(uri).body(dto);
    
  }

  @PutMapping(value = "/{id}")
  @ApiOperation(value = "Altera dados da pessoa", notes = "Altera dados da pessoa")
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Altera dados da pessoa"),
      @ApiResponse(code = 401, message = "Erro de autenticação"),
      @ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
      @ApiResponse(code = 404, message = "Recurso não encontrado"),
      @ApiResponse(code = 505, message = "Exceção interna da aplicação"),
  })
  public ResponseEntity<SkillDTO> atualizar(@Valid @PathVariable Integer id, @RequestBody SkillDTO skillDTO) {
    skillDTO = skillService.atualizar(id, skillDTO);
    return ResponseEntity.ok(skillDTO);
  }

  @DeleteMapping(value = "/{id}")
  @ApiOperation(value = "Deleta pessoa", notes = "Deleta pessoa")
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Deleta pessoa"),
      @ApiResponse(code = 401, message = "Erro de autenticação"),
      @ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
      @ApiResponse(code = 404, message = "Recurso não encontrado"),
      @ApiResponse(code = 505, message = "Exceção interna da aplicação"),
  })
  public ResponseEntity<Void> deletar(@PathVariable Integer id) {
    skillService.deletar(id);
    return ResponseEntity.noContent().build();
  }


}