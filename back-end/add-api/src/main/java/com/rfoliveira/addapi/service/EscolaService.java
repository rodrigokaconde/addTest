package com.rfoliveira.addapi.service;

import com.rfoliveira.addapi.entity.Escola;
import com.rfoliveira.addapi.repository.EscolaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EscolaService {
    @Autowired
    private EscolaRepository escolaRepository;

    public ResponseEntity<Escola> createEscola(Escola escola) {
        return ResponseEntity.ok().body(escolaRepository.save(escola));
    }

    public ResponseEntity<List<Escola>> getAllEscolas() {
        List <Escola> escolas = escolaRepository.findAll();
        return ResponseEntity.ok().body(escolas);
    }


    public ResponseEntity<Optional<Escola>> getByIdEscola(Integer id) {
        verifyExistisEscola(id);
        return ResponseEntity.ok().body(escolaRepository.findById(id));
    }

    public ResponseEntity deleteByIdEscola(Integer id) {
        verifyExistisEscola(id);
        escolaRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity updateEscola(Escola escola) {
        verifyExistisEscola(escola.getId());
        escolaRepository.save(escola);
        return ResponseEntity.ok().build();
    }

    private Escola verifyExistisEscola(Integer id){
        return escolaRepository.findById(id).orElseThrow();
    }
}
