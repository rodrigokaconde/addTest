package com.rfoliveira.addapi.service;

import com.rfoliveira.addapi.entity.Aluno;
import com.rfoliveira.addapi.entity.Turma;
import com.rfoliveira.addapi.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurmaService {

    @Autowired
    TurmaRepository turmaRepository;

    public ResponseEntity<Turma> createTurma(Turma turma) {
        return ResponseEntity.ok().body(turmaRepository.save(turma));
    }

    public ResponseEntity<List<Turma>> getAllTurmas() {
        List <Turma> turmas = turmaRepository.findAll();
        return ResponseEntity.ok().body(turmas);
    }


    public ResponseEntity<Optional<Turma>> getByIdTurma(Integer id) {
        verifyExistisTurma(id);
        return ResponseEntity.ok().body(turmaRepository.findById(id));
    }

    public ResponseEntity deleteByIdTurma(Integer id) {
        verifyExistisTurma(id);
        turmaRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity updateTurma(Turma turma) {
        verifyExistisTurma(turma.getId());
        turmaRepository.save(turma);
        return ResponseEntity.ok().build();
    }

    private Turma verifyExistisTurma(Integer id){
        return turmaRepository.findById(id).orElseThrow();
    }
}
