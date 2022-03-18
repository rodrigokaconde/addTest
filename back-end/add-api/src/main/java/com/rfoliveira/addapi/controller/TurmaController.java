package com.rfoliveira.addapi.controller;

import com.rfoliveira.addapi.entity.Turma;
import com.rfoliveira.addapi.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/turma")
public class TurmaController {
    @Autowired
    TurmaService turmaService;

    @PostMapping
    public ResponseEntity<Turma> createTurma (@RequestBody Turma turma){
        return turmaService.createTurma(turma);
    }

    @GetMapping
    public ResponseEntity<List<Turma>> getAllTurmas(){
        return turmaService.getAllTurmas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Turma>> getByIdTurma (@PathVariable Integer id){
        return turmaService.getByIdTurma(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteByIdTurma(@PathVariable Integer id){
        return turmaService.deleteByIdTurma(id);
    }

    @PutMapping
    public ResponseEntity updateTurma(@RequestBody Turma turma){
        return turmaService.updateTurma(turma);
    }
}
