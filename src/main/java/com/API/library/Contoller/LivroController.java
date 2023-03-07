package com.API.library.Contoller;

import com.API.library.Dto.DadosAtualizacaoLivro;
import com.API.library.Dto.DadosCadastroLivro;
import com.API.library.Entity.Livro;
import com.API.library.Service.LivroService;
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
        livroService.criarNovoLivro(dados);
    }
    @GetMapping
    public List<Livro> buscar(){
        return livroService.getLivroRepository().stream().toList();
    }

    @GetMapping("/disponivel")
    public List<Livro> listaLivrosDisponiveis(){
        return LivroService.listaLivros();
    }
    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoLivro dados){
        livroService.atualizar(dados);
    }
}