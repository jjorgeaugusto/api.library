package com.API.library.Entity;

import com.API.library.Dto.DadosAtualizacaoLivro;
import com.API.library.Dto.DadosCadastroLivro;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Livro")
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero")
    private Long id;
    @Column(name = "nome")
    public String nome;
    @Column(name = "autor")
    public String autor;
    @Column(name = "status")
    public Status status;

    public Livro(DadosCadastroLivro dados, Status status){
        this.nome = dados.nome();
        this.autor = dados.autor();
        this.status = dados.status();
    }
    public Livro(Long id, String nome, String autor, Status status){
    }
    public void atualizarInformacoes(DadosAtualizacaoLivro dados) {
        if(dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.autor() != null) {
            this.autor = dados.autor();
        }
        if (dados.status() != null){
            this.status = dados.status();
        }
    }
}
