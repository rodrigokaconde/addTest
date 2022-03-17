package com.rfoliveira.addapi.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private LocalDate dataNascimento;

    //@ManyToOne(cascade=CascadeType.ALL)
    //@JoinColumn(name="turma_id", referencedColumnName="id",nullable=false)
    @ManyToOne
    @JoinColumn(name="turma_id")
    private Turma turma;

}
