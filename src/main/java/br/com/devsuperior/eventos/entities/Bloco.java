package br.com.devsuperior.eventos.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_bloco")
public class Bloco implements Serializable {
  @Serial private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private Instant inicio;
  private Instant fim;

  @ManyToOne
  @JoinColumn(name = "atividade")
  private Atividade atividade;

  public Bloco() {}

  public Bloco(Integer id, Instant inicio, Instant fim, Atividade atividade) {
    this.id = id;
    this.inicio = inicio;
    this.fim = fim;
    this.atividade = atividade;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Instant getInicio() {
    return inicio;
  }

  public void setInicio(Instant inicio) {
    this.inicio = inicio;
  }

  public Instant getFim() {
    return fim;
  }

  public void setFim(Instant fim) {
    this.fim = fim;
  }

  public Atividade getAtividade() {
    return atividade;
  }

  public void setAtividade(Atividade atividade) {
    this.atividade = atividade;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Bloco bloco = (Bloco) o;
    return Objects.equals(id, bloco.id)
        && Objects.equals(inicio, bloco.inicio)
        && Objects.equals(fim, bloco.fim)
        && Objects.equals(atividade, bloco.atividade);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, inicio, fim, atividade);
  }

  @Override
  public String toString() {
    return "Bloco{" + "id=" + id + ", inicio=" + inicio + ", fim=" + fim + '}';
  }
}
