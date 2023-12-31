package br.com.devsuperior.eventos.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "tb_categoria")
public class Categoria implements Serializable {

  @Serial private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String descricao;

  @OneToMany(mappedBy = "categoria")
  private Set<Atividade> atividades = new HashSet<>();

  public Categoria() {}

  public Categoria(Integer id, String descricao) {
    this.id = id;
    this.descricao = descricao;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public Set<Atividade> getAtividades() {
    return atividades;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Categoria categoria = (Categoria) o;
    return Objects.equals(id, categoria.id) && Objects.equals(descricao, categoria.descricao);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, descricao);
  }

  @Override
  public String toString() {
    return "Categoria{" + "id=" + id + ", descricao='" + descricao + '\'' + '}';
  }
}
