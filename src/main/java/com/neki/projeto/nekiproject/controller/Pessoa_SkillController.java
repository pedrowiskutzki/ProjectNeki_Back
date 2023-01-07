package com.neki.projeto.nekiproject.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.neki.projeto.nekiproject.DTO.Pessoa_SkillDTO;
import com.neki.projeto.nekiproject.model.Pessoa_Skill;
import com.neki.projeto.nekiproject.service.Pessoa_SkillService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/pessoa_skill")
public class Pessoa_SkillController {

  @Autowired
  private Pessoa_SkillService pessoa_skillService;

  @GetMapping(value = "/{id}")
  @ApiOperation(value = "Lista dados de pessoa skill", notes = "Lista dados de pessoa skill")
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Lista dados de pessoa skill"),
      @ApiResponse(code = 401, message = "Erro de autenticação"),
      @ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
      @ApiResponse(code = 404, message = "Recurso não encontrado"),
      @ApiResponse(code = 505, message = "Exceção interna da aplicação"),
  })
  public ResponseEntity<Pessoa_SkillDTO> obterPorId(@PathVariable Integer id) {
    Pessoa_SkillDTO dto = pessoa_skillService.obterPorId(id);
    return ResponseEntity.ok(dto);
  }

  @GetMapping
  @ApiOperation(value = "Lista todas as pessoas", notes = "Lista todas as pessoas")
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Lista todas pessoas"),
      @ApiResponse(code = 401, message = "Erro de autenticação"),
      @ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
      @ApiResponse(code = 404, message = "Recurso não encontrado"),
      @ApiResponse(code = 505, message = "Exceção interna da aplicação"),
  })
  public ResponseEntity<List<Pessoa_SkillDTO>> obterTodos() {
    List<Pessoa_SkillDTO> dto = pessoa_skillService.obterTodos();
    return ResponseEntity.ok(dto);
  }

  @PostMapping
  @ApiOperation(value = "Cadastra pessoa", notes = "Cadastra pessoa")
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Cadastra pessoa"),
      @ApiResponse(code = 401, message = "Erro de autenticação"),
      @ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
      @ApiResponse(code = 404, message = "Recurso não encontrado"),
      @ApiResponse(code = 505, message = "Exceção interna da aplicação"),
  })
  public ResponseEntity<Pessoa_SkillDTO> cadastrar(@Valid @RequestBody Pessoa_Skill pessoa_skill) {
    Pessoa_SkillDTO dto = pessoa_skillService.cadastrar(pessoa_skill);
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
  public ResponseEntity<Pessoa_SkillDTO> atualizar(@Valid @PathVariable Integer id, @RequestBody Pessoa_SkillDTO pessoa_skillDTO) {
    pessoa_skillDTO = pessoa_skillService.atualizar(id, pessoa_skillDTO);
    return ResponseEntity.ok(pessoa_skillDTO);
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
    pessoa_skillService.deletar(id);
    return ResponseEntity.noContent().build();
  }


}