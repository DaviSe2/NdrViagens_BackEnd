package br.com.ndrviagens.controller;

import br.com.ndrviagens.model.RoteiroViagem;
import br.com.ndrviagens.repository.RoteiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/roteiro")
@CrossOrigin("*")
public class RoteiroController {

    @Autowired
    private RoteiroRepository repository;

    @GetMapping
    public ResponseEntity<List<RoteiroViagem>> getAllRoteiroViagem(){
        return ResponseEntity.ok().body(repository.findAll());
    }

    @PostMapping
    public ResponseEntity<RoteiroViagem> saveRoteiro(@RequestBody RoteiroViagem roteiro){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(roteiro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RoteiroViagem> deleteRoteiro(@PathVariable long id){
        RoteiroViagem roteiroViagem = null;
        Optional<RoteiroViagem> roteiroViagemOptional = repository.findById(id);
        if (roteiroViagemOptional.isPresent()){
            roteiroViagem = roteiroViagemOptional.get();
            repository.deleteById(id);
        }
        return ResponseEntity.status(HttpStatus.OK).body(roteiroViagem);
    }
}
