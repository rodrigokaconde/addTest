package com.rfoliveira.addapi.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private int capacidade;

    //@OneToMany(mappedBy = "turma", fetch = FetchType.LAZY, cascade = {CascadeType.DETACH})
    @OneToMany(mappedBy = "turma")
    private List<Aluno> alunos;

    //@ManyToOne(cascade=CascadeType.ALL)
   //@JoinColumn(name="escola_id", referencedColumnName="id",nullable=false)
    @ManyToOne
    @JoinColumn(name="escola_id")
    private Escola escola;

}
