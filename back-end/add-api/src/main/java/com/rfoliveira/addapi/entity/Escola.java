package com.rfoliveira.addapi.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Escola {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @OneToOne(cascade = {CascadeType.DETACH})
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    //@OneToMany(mappedBy = "escola", fetch = FetchType.LAZY, cascade = {CascadeType.DETACH})
    @OneToMany(mappedBy = "escola")
    private List<Turma> turmas;
}
