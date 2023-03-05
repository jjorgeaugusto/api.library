package com.API.library.Entity;

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
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero")
    private Long id;
    @Column(name = "nome")
    public String nome;

    public Livro(DadosCadastroLivro dados){
        this.nome = dados.nome();
    }

}
