package br.fmp.av2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "nome é obrigatório")
    @Size(min = 2, max = 60, message = "nome deve ter entre 2 e 60 caracteres")
    @Column(nullable = false, length = 60)
    private String nome;

    @NotNull(message = "idade é obrigatória")
    @Min(value = 18, message = "idade mínima é 18")
    @Column(nullable = false)
    private Integer idade;

    public Aluno() {}

    public Aluno(String nome, Integer idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public Long getId() { return id; }
    public String getNome() { return nome; }
    public Integer getIdade() { return idade; }

    public void setId(Long id) { this.id = id; }
    public void setNome(String nome) { this.nome = nome; }
    public void setIdade(Integer idade) { this.idade = idade; }
}
