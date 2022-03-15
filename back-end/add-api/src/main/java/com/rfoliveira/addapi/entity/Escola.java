package com.rfoliveira.addapi.entity;

import lombok.Data;

import javax.persistence.*;

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
}
