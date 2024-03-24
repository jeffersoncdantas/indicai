package com.indicai.indicai.itens.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.indicai.indicai.itens.entity.Filme;
import com.indicai.indicai.itens.repository.FilmeRepository;

@RestController
@RequestMapping(value = "/api")
public class FilmeController {

  @Autowired
  private FilmeRepository repository;

  public FilmeController(){}

  @GetMapping("/filmes")
  public List<Filme> getFilmes() {
      return repository.findAll();
  }

  @GetMapping("/filmes/{id}")
  public Optional<Filme> getFilme(@PathVariable long id) {
      Optional<Filme> opt = repository.findById(id);
      
      if(opt.isPresent()){
          return opt;
      } throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Erro ao buscar filme com id " + id);
  } 

  @PostMapping("/filmes")
  public Filme postFilme(@RequestBody Filme filme) {
      return repository.save(filme);
  }

  @PutMapping("/filmes/{filmeId}")
  public Optional<Filme> updateFilme(@RequestBody Filme filme, @PathVariable(value= "filmeId") long filmeId){
    Optional<Filme> opt = this.getFilme(filmeId);
    if (opt.isPresent() && opt.get().getId() == filme.getId()){
      return Optional.of(repository.save(filme));
    } throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Erro ao alterar dados do filme com id" + filmeId);
  }

    
  @DeleteMapping(value = "/filmes/{id}")
  public void deleteFilme(@PathVariable long id){
    if(repository.findById(id) == null){
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "O servidor não encontrou nada que corresponda ao request.");
    }
    repository.deleteById(id);
  }
}
    
