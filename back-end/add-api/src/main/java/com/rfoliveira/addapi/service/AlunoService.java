package com.rfoliveira.addapi.service;

import com.rfoliveira.addapi.entity.Aluno;
import com.rfoliveira.addapi.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;


    public ResponseEntity<Aluno> createAluno(Aluno aluno) {
        return ResponseEntity.ok().body(alunoRepository.save(aluno));
    }

    public ResponseEntity<List<Aluno>> getAllAlunos() {
        List <Aluno> alunos = alunoRepository.findAll();
        return ResponseEntity.ok().body(alunos);
    }

    public ResponseEntity<Optional<Aluno>> getByIdAluno(Integer id) {
        verifyExistisAluno(id);
        return ResponseEntity.ok().body(alunoRepository.findById(id));
    }

    public ResponseEntity deleteByIdAluno(Integer id) {
        verifyExistisAluno(id);
        alunoRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity updateAluno(Aluno aluno) {
        verifyExistisAluno(aluno.getId());
        alunoRepository.save(aluno);
        return ResponseEntity.ok().build();
    }

    private Aluno verifyExistisAluno(Integer id){
        return alunoRepository.findById(id).orElseThrow();
    }
}
