package com.API.library.service;

import com.API.library.dto.DadosAtualizacaoLivro;
import com.API.library.dto.DadosCadastroLivro;
import com.API.library.entity.Status;
import com.API.library.entity.Livro;
import com.API.library.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }
    public List<Livro> listarTodosLivros(){
        return livroRepository.findAll();
    }
    public List<Livro> listaLivrosDisponivel(){
        return listarTodosLivros().stream().filter(l -> l.getStatus() == Status.DISPONIVEL).toList();
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
