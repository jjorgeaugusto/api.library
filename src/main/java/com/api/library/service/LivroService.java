package com.api.library.service;

import com.api.library.entity.Livro;
import com.api.library.dto.DadosAtualizacaoLivro;
import com.api.library.dto.DadosCadastroLivro;
import com.api.library.entity.Status;
import com.api.library.exception.LivroJaExistenteException;
import com.api.library.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<Livro> listaLivrosDisponivel() {
        return listarTodosLivros().stream().filter(l -> l.getStatus().equals(Status.DISPONIVEL))
                .collect(Collectors.toList());
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
    public boolean verificaNomeLivro(DadosCadastroLivro dados) {
        return livroRepository.existsByNome(dados.nome());
    }

    public void novoLivroVerificado(DadosCadastroLivro dados) throws LivroJaExistenteException {
        if (!verificaNomeLivro(dados)){
            criarNovoLivro(dados);
        }
        else {
            throw new LivroJaExistenteException("Livro com nome " + dados.nome() + " já existe.");
        }
    }
}