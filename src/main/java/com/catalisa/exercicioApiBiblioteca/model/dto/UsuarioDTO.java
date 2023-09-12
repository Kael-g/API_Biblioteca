package com.catalisa.exercicioApiBiblioteca.model.dto;

import com.catalisa.exercicioApiBiblioteca.model.RoleModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    private Long id;
    private String username;
    private List<RoleModel> roles;
}
