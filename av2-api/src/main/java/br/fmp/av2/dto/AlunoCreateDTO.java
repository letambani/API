package br.fmp.av2.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AlunoCreateDTO {

    @NotBlank(message = "nome é obrigatório")
    @Size(min = 2, max = 60, message = "nome deve ter entre 2 e 60 caracteres")
    private String nome;

    @NotNull(message = "idade é obrigatória")
    @Min(value = 18, message = "idade mínima é 18")
    private Integer idade;

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Integer getIdade() { return idade; }
    public void setIdade(Integer idade) { this.idade = idade; }
}
