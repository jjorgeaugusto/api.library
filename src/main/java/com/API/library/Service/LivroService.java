package com.API.library.Service;

import com.API.library.Entity.Livro;
import com.API.library.Repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public List<Livro> getLivroRepository(){
        return livroRepository.findAll();
    }
}
