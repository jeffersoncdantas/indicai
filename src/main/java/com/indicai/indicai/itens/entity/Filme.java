package com.indicai.indicai.itens.entity;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;


@Entity
@Table(name="filmes")
public class Filme {
  @Id 
  @GeneratedValue
  private long id;
  private String titulo;
  private String diretor;
  private String elencoPrincipal;
  private String pais;
  private String anoLancamento;
  private float nota;

  public Filme() {
  }

   public Filme(long id, String titulo, String diretor, String elencoPrincipal, String pais, String anoLancamento,
        float nota) {
    this.id = id;
    this.titulo = titulo;
    this.diretor = diretor;
    this.elencoPrincipal = elencoPrincipal;
    this.pais = pais;
    this.anoLancamento = anoLancamento;
    this.nota = nota;
}

public long getId() {
    return id;
}

public void setId(long id) {
    this.id = id;
}

public String getTitulo() {
    return titulo;
}

public void setTitulo(String titulo) {
    this.titulo = titulo;
}

public String getDiretor() {
    return diretor;
}

public void setDiretor(String diretor) {
    this.diretor = diretor;
}

public String getElencoPrincipal() {
    return elencoPrincipal;
}

public void setElencoPrincipal(String elencoPrincipal) {
    this.elencoPrincipal = elencoPrincipal;
}

public String getPais() {
    return pais;
}

public void setPais(String pais) {
    this.pais = pais;
}

public String getAnoLancamento() {
    return anoLancamento;
}

public void setAnoLancamento(String anoLancamento) {
    this.anoLancamento = anoLancamento;
}

public float getNota() {
    return nota;
}

public void setNota(float nota) {
    this.nota = nota;
}

@Override
public String toString() {
    return "Filme [id=" + id + ", titulo=" + titulo + ", diretor=" + diretor + ", elencoPrincipal=" + elencoPrincipal
            + ", pais=" + pais + ", anoLancamento=" + anoLancamento + ", nota=" + nota + "]";
}
 
}
