package br.com.devsuperior.eventos.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_atividade")
public class Atividade implements Serializable {

  @Serial private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String nome;

  private String descricao;

  private Double preco;

  @ManyToOne
  @JoinColumn(name = "categoria")
  private Categoria categoria;

  @OneToMany(mappedBy = "atividade")
  private Set<Bloco> blocos = new HashSet<>();

  public Atividade() {}

  public Atividade(Integer id, String nome, String descricao, Double preco, Categoria categoria) {
    this.id = id;
    this.nome = nome;
    this.descricao = descricao;
    this.preco = preco;
    this.categoria = categoria;
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

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public Double getPreco() {
    return preco;
  }

  public void setPreco(Double preco) {
    this.preco = preco;
  }

  public Categoria getCategoria() {
    return categoria;
  }

  public void setCategoria(Categoria categoria) {
    this.categoria = categoria;
  }

  public Set<Bloco> getBlocos() {
    return blocos;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Atividade atividade = (Atividade) o;
    return Objects.equals(id, atividade.id)
        && Objects.equals(nome, atividade.nome)
        && Objects.equals(descricao, atividade.descricao)
        && Objects.equals(preco, atividade.preco);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nome, descricao, preco);
  }

  @Override
  public String toString() {
    return "Atividade{"
        + "id="
        + id
        + ", nome='"
        + nome
        + '\''
        + ", descricao='"
        + descricao
        + '\''
        + ", preco="
        + preco
        + '}';
  }
}
