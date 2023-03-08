package com.api.library.controller;

import com.api.library.entity.Livro;
import com.api.library.service.LivroService;
import com.api.library.dto.DadosAtualizacaoLivro;
import com.api.library.dto.DadosCadastroLivro;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/livro")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroLivro dados){
        livroService.novoLivroVerificado(dados);
    }
    @GetMapping
    public List<Livro> buscar(){
        return livroService.listarTodosLivros().stream().toList();
    }

    @GetMapping("/disponivel")
    public List<Livro> listaLivrosDisponiveis(){
        return livroService.listaLivrosDisponivel();
    }
    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoLivro dados){
        livroService.atualizar(dados);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        livroService.inativarLivro(id);
    }
}