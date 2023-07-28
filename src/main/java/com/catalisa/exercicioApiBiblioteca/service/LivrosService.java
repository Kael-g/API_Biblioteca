package com.catalisa.exercicioApiBiblioteca.service;

import com.catalisa.exercicioApiBiblioteca.model.LivrosModel;
import com.catalisa.exercicioApiBiblioteca.repository.LivrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivrosService {
    @Autowired
    LivrosRepository livrosRepository;

    public List<LivrosModel> mostrarTodos() {
        return livrosRepository.findAll();
    }

    public Optional<LivrosModel> mostrarLivroPorId(Long idLivro) {
        return livrosRepository.findById(idLivro);
    }

    public LivrosModel alterarLivro(Long idLivro, LivrosModel livroAtualizado) {
        LivrosModel livro = mostrarLivroPorId(idLivro).get();

        if (livroAtualizado.getAutor() != null && livroAtualizado.getAutor().length() > 0){
            livro.setAutor(livroAtualizado.getAutor());
        }

        if (livroAtualizado.getTitulo() != null && livroAtualizado.getTitulo().length() > 0){
            livro.setTitulo(livroAtualizado.getTitulo());
        }

        if (livroAtualizado.getDataLancamento() != null & livroAtualizado.getDataLancamento().length() > 0){
            livro.setDataLancamento(livroAtualizado.getDataLancamento());
        }

        return livrosRepository.save(livro);
    }

    public LivrosModel adicionarLivro(LivrosModel livrosModel) {
        return livrosRepository.save(livrosModel);
    }

    public void deletarLivro(Long idLivro) {
        livrosRepository.deleteById(idLivro);
    }
}
