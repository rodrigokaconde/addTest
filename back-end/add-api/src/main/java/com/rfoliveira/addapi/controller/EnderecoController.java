package com.rfoliveira.addapi.controller;

import com.rfoliveira.addapi.entity.Endereco;
import com.rfoliveira.addapi.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

    @PostMapping
    public ResponseEntity<Endereco> createEndereco (@RequestBody Endereco endereco){
        return enderecoService.createEndereco(endereco);
    }

    @GetMapping
    public ResponseEntity<List<Endereco>> getAllEnderecos(){

        return enderecoService.getAllEnderecos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Endereco>> getByIdEndereco (@PathVariable Integer id){
        return enderecoService.getByIdEndereco(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteByIdEndereco(@PathVariable Integer id){
        return enderecoService.deleteByIdEndereco(id);
    }

    @PutMapping
    public ResponseEntity updateEndereco(@RequestBody Endereco endereco){
        return enderecoService.updateEndereco(endereco);
    }
}
