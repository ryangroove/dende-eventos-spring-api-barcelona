package br.com.dendeeventos.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "organizadores")
public class Organizador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private LocalDate dataNascimento;

    private String sexo;

    private String email;

    private String cnpj;

    private String razaoSocial;

    private String nomeFantasia;

    @OneToMany(mappedBy = "organizador")
    private List<Evento> eventos;
}