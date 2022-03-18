package com.rfoliveira.addapi.controller;

import com.rfoliveira.addapi.entity.Aluno;
import com.rfoliveira.addapi.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
    @Autowired
    private AlunoService alunoService;

    @PostMapping
    public ResponseEntity<Aluno> createAluno (@RequestBody Aluno aluno){
        System.out.println(aluno.toString());
        return alunoService.createAluno(aluno);
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> getAllAlunos(){
        return alunoService.getAllAlunos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Aluno>> getByIdAluno (@PathVariable Integer id){
        return alunoService.getByIdAluno(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteByIdAluno(@PathVariable Integer id){
        return alunoService.deleteByIdAluno(id);
    }

    @PutMapping
    public ResponseEntity updateAluno(@RequestBody Aluno aluno){
        return alunoService.updateAluno(aluno);
    }
}
