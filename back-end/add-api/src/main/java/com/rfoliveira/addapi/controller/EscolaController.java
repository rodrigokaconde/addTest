package com.rfoliveira.addapi.controller;

import com.rfoliveira.addapi.entity.Escola;
import com.rfoliveira.addapi.service.EscolaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/escola")
public class EscolaController {
    @Autowired
    private EscolaService escolaService;

    @PostMapping
    public ResponseEntity<Escola> createEscola (@RequestBody Escola escola){
        return escolaService.createEscola(escola);
    }

    @GetMapping
    public ResponseEntity<List<Escola>> getAllEscolas(){
        return escolaService.getAllEscolas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Escola>> getByIdEscola (@PathVariable Integer id){
        return escolaService.getByIdEscola(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteByIdEscola(@PathVariable Integer id){
        return escolaService.deleteByIdEscola(id);
    }

    @PutMapping
    public ResponseEntity updateEscola(@RequestBody Escola escola){
        return escolaService.updateEscola(escola);
    }
}
