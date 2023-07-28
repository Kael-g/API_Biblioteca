package com.catalisa.exercicioApiBiblioteca.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tb_Livros")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LivrosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLivro;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String autor;

    @Column(nullable = false)
    private String dataLancamento;

    @Column(nullable = false)
    private String codigoLivro;
}
