package com.rfoliveira.addapi.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Integer;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private int capacidade;

    @OneToMany(mappedBy = "turma")
    private List<Aluno> alunos;

    @ManyToOne
    @JoinColumn(name = "escola_id")
    private Escola escola;
}
