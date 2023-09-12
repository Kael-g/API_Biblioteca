package com.catalisa.exercicioApiBiblioteca.service;

import com.catalisa.exercicioApiBiblioteca.model.RoleModel;
import com.catalisa.exercicioApiBiblioteca.model.UsuarioModel;
import com.catalisa.exercicioApiBiblioteca.model.dto.UsuarioDTO;
import com.catalisa.exercicioApiBiblioteca.repository.RoleRepository;
import com.catalisa.exercicioApiBiblioteca.repository.UsuarioRepository;
import com.catalisa.exercicioApiBiblioteca.security.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    public List<UsuarioDTO> buscarTodosUsuarios() {
        List<UsuarioModel> usuarios = usuarioRepository.findAll();
        List<UsuarioDTO> usuariosDTOS = new ArrayList<>();

        for(UsuarioModel usuario : usuarios){
            UsuarioDTO usuarioDTO = new UsuarioDTO();

            usuarioDTO.setId(usuario.getId_usuario());
            usuarioDTO.setUsername(usuario.getUsername());
            usuarioDTO.setRoles(usuario.getRoles());

            usuariosDTOS.add(usuarioDTO);
        }

        return usuariosDTOS;
    }

    public UsuarioModel cadastrarUsuario(UsuarioModel usuarioModel) {

        String senhaCriptografada = new BCryptPasswordEncoder().encode(usuarioModel.getPassword());
        usuarioModel.setPassword(senhaCriptografada);

        return usuarioRepository.save(usuarioModel);
    }


    public void associarRoleAUsuario(Long id, Long idRole){
        UsuarioModel usuarioModel = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário(a) não localizado(a)/cadastrado(a)."));

        RoleModel roleModel = roleRepository.findById(idRole)
                .orElseThrow(() -> new EntityNotFoundException("Role não localizada/cadastrada."));

        usuarioModel.getRoles().add(roleModel);
        usuarioRepository.save(usuarioModel);
    }

    public void deletarUsuario(Long id) {
        UsuarioModel usuarioModel = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário(a) não localizado(a)/cadastrado(a)."));

        usuarioRepository.deleteById(id);
    }
}
