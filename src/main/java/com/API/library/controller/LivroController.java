package com.API.library.controller;

import com.API.library.dto.DadosAtualizacaoLivro;
import com.API.library.dto.DadosCadastroLivro;
import com.API.library.dto.DadosListagemLivro;
import com.API.library.entity.Livro;
import com.API.library.entity.Status;
import com.API.library.service.LivroService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/livro")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroLivro dados){
        livroService.criarNovoLivro(dados);
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