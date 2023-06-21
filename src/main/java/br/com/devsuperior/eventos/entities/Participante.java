package br.com.devsuperior.eventos.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_participante")
public class Participante implements Serializable {
  @Serial private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String nome;

  private String email;

  @ManyToMany(mappedBy = "participantes")
  private Set<Atividade> atividades = new HashSet<>();

  public Participante() {}

  public Participante(Integer id, String nome, String email) {
    this.id = id;
    this.nome = nome;
    this.email = email;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Set<Atividade> getAtividades() {
    return atividades;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Participante that = (Participante) o;
    return Objects.equals(id, that.id)
        && Objects.equals(nome, that.nome)
        && Objects.equals(email, that.email)
        && Objects.equals(atividades, that.atividades);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nome, email, atividades);
  }

  @Override
  public String toString() {
    return "Participante{"
        + "id="
        + id
        + ", nome='"
        + nome
        + '\''
        + ", email='"
        + email
        + '\''
        + '}';
  }
}
