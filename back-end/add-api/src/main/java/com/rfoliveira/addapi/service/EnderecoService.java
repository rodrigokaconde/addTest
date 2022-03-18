package com.rfoliveira.addapi.service;

import com.rfoliveira.addapi.entity.Endereco;
import com.rfoliveira.addapi.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {
    @Autowired
    EnderecoRepository enderecoRepository;

    public ResponseEntity<Endereco> createEndereco(Endereco endereco) {
        return ResponseEntity.ok().body(enderecoRepository.save(endereco));
    }

    public ResponseEntity<List<Endereco>> getAllEnderecos() {
        List <Endereco> enderecos = enderecoRepository.findAll();
        return ResponseEntity.ok().body(enderecos);
    }

    public ResponseEntity<Optional<Endereco>> getByIdEndereco(Integer id) {
        verifyExistisEndereco(id);
        return ResponseEntity.ok().body(enderecoRepository.findById(id));
    }

    public ResponseEntity deleteByIdEndereco(Integer id) {
        verifyExistisEndereco(id);
        enderecoRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity updateEndereco(Endereco endereco) {
        verifyExistisEndereco(endereco.getId());
        enderecoRepository.save(endereco);
        return ResponseEntity.ok().build();
    }

    private Endereco verifyExistisEndereco(Integer id){
        return enderecoRepository.findById(id).orElseThrow();
    }
}
