package com.rfoliveira.addapi.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Escola {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nome;

    @OneToOne
    private Endereco endereco;

    @OneToMany(mappedBy = "escola")
    private List<Turma> turmas;
}
