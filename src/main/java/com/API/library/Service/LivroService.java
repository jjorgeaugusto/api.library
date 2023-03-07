package com.API.library.Service;

import com.API.library.Dto.DadosAtualizacaoLivro;
import com.API.library.Dto.DadosCadastroLivro;
import com.API.library.Entity.Status;
import com.API.library.Entity.Livro;
import com.API.library.Repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivroService {

    @Autowired
    private static LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public List<Livro> getLivroRepository(){
        return livroRepository.findAll();
    }
    public List<Livro> listarTodosLivros(){
        return livroRepository.findAll();
    }
    public static List<Livro> listaLivros(){
        return livroRepository.findAll().stream().filter(l -> l.getStatus() == Status.DISPONIVEL).collect(Collectors.toList());
    }
    public void criarNovoLivro(DadosCadastroLivro dados) {
        livroRepository.save(new Livro(dados, Status.DISPONIVEL));
    }
    public void atualizar(DadosAtualizacaoLivro dados){
        Livro livro = livroRepository.getReferenceById(Math.toIntExact(dados.id()));
        livro.atualizarInformacoes(dados);
    }

    public void inativarLivro(Long id){
        var livro = livroRepository.getReferenceById(Math.toIntExact(id));
        livro.inativo();
    }
}
