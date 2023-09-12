package com.catalisa.exercicioApiBiblioteca.controller;

import com.catalisa.exercicioApiBiblioteca.model.LivrosModel;
import com.catalisa.exercicioApiBiblioteca.service.LivrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LivrosController {
    @Autowired
    LivrosService livrosService;

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping(path = "/livros")
    public List<LivrosModel> mostrarTodos(){
        return livrosService.mostrarTodos();
    }

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping(path = "/livros/{idLivro}")
    public Optional<LivrosModel> mostrarLivroPorId (@PathVariable Long idLivro){
        return livrosService.mostrarLivroPorId(idLivro);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PutMapping(path = "/livros/{idLivro}")
    public LivrosModel alterarLivro (@PathVariable Long idLivro, @RequestBody LivrosModel livrosModel){
        return livrosService.alterarLivro(idLivro, livrosModel);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping(path = "/livros")
    public LivrosModel adicionarLivro (@RequestBody LivrosModel livrosModel){
        return livrosService.adicionarLivro(livrosModel);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @DeleteMapping(path = "/livros/{idLivro}")
    public void deletarLivro (@PathVariable Long idLivro){
        livrosService.deletarLivro(idLivro);
    }
}
