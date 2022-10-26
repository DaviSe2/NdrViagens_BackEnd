package br.com.ndrviagens.controller;

import br.com.ndrviagens.model.PacoteViagem;
import br.com.ndrviagens.model.RoteiroViagem;
import br.com.ndrviagens.repository.RoteiroRepository;
import br.com.ndrviagens.service.RoteiroService;
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

    @Autowired private RoteiroService service;

    @GetMapping
    public ResponseEntity<List<RoteiroViagem>> getAllRoteiroViagem(){
        return ResponseEntity.ok().body(service.getAllRoteiroViagem());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoteiroViagem> getRoteiroById(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getRoteiroById(id));
    }

    @PostMapping
    public ResponseEntity<RoteiroViagem> saveRoteiro(@RequestBody RoteiroViagem roteiro){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveRoteiro(roteiro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RoteiroViagem> deleteRoteiro(@PathVariable long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.deleteRoteiro(id));
    }
}
