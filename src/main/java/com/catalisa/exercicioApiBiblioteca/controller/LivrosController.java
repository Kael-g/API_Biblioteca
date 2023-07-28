package com.catalisa.exercicioApiBiblioteca.controller;

import com.catalisa.exercicioApiBiblioteca.model.LivrosModel;
import com.catalisa.exercicioApiBiblioteca.service.LivrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LivrosController {
    @Autowired
    LivrosService livrosService;
    @GetMapping(path = "/livros")
    public List<LivrosModel> mostrarTodos(){
        return livrosService.mostrarTodos();
    }

    @GetMapping(path = "/livros/{idLivro}")
    public Optional<LivrosModel> mostrarLivroPorId (@PathVariable Long idLivro){
        return livrosService.mostrarLivroPorId(idLivro);
    }

    @PutMapping(path = "/livros/{idLivro}")
    public LivrosModel alterarLivro (@PathVariable Long idLivro, @RequestBody LivrosModel livrosModel){
        return livrosService.alterarLivro(idLivro, livrosModel);
    }

    @PostMapping(path = "/livros")
    public LivrosModel adicionarLivro (@RequestBody LivrosModel livrosModel){
        return livrosService.adicionarLivro(livrosModel);
    }

    @DeleteMapping(path = "/livros/{idLivro}")
    public void deletarLivro (@PathVariable Long idLivro){
        livrosService.deletarLivro(idLivro);
    }
}
