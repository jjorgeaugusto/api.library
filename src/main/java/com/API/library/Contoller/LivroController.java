package com.API.library.Contoller;

import com.API.library.Dto.DadosCadastroLivro;
import com.API.library.Entity.Livro;
import com.API.library.Repository.LivroRepository;
import com.API.library.Service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/livro")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @Autowired
    private LivroRepository livroRepository;

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroLivro dados){
        livroRepository.save(new Livro(dados));
    }

    @GetMapping
    public List<Livro> buscar(){
        return livroService.getLivroRepository();
    }
}
