package com.catalisa.exercicioApiBiblioteca.controller;

import com.catalisa.exercicioApiBiblioteca.model.UsuarioModel;
import com.catalisa.exercicioApiBiblioteca.model.dto.UsuarioDTO;
import com.catalisa.exercicioApiBiblioteca.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping(path = "/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;


    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listarUsuarios() {
        List<UsuarioDTO> usuarios = usuarioService.buscarTodosUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<?> cadastrarUsuario(@RequestBody UsuarioModel usuarioModel) {
        try {
            UsuarioModel usuario = usuarioService.cadastrarUsuario(usuarioModel);
            return ResponseEntity.status(HttpStatus.CREATED).body("Cadastro realizado com sucesso!");
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<?> fornecerAcesso(@PathVariable Long id, @RequestBody Long idRole){
        try {
            usuarioService.associarRoleAUsuario(id, idRole);
            return ResponseEntity.ok("Acesso fornecido/atualizado com sucesso!");
        } catch (EntityNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarUsuario(@PathVariable Long id) {
        try {
            usuarioService.deletarUsuario(id);
            return ResponseEntity.ok("Usuário(a) excluído(a) com sucesso!");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
