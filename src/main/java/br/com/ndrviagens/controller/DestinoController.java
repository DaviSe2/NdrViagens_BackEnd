package br.com.ndrviagens.controller;

import br.com.ndrviagens.model.Destino;
import br.com.ndrviagens.repository.DestinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Controller
@RequestMapping("/destino")
@CrossOrigin("*")
public class DestinoController {

    @Autowired
    private DestinoRepository repository;

    @GetMapping
    public ResponseEntity<List<Destino>> getAllDestinos(){
        return ResponseEntity.ok().body(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Destino> getDestinoById(@PathVariable long id){
        Destino destino = null;
        Optional<Destino> destinoOptional = repository.findById(id);
        if(destinoOptional.isPresent()){
            destino = destinoOptional.get();
        }
        return ResponseEntity.status(HttpStatus.OK).body(destino);
    }

    @PostMapping
    public ResponseEntity<Destino> saveDestino(@RequestBody Destino destino){
        destino.setCidade(destino.getCidade().toUpperCase());
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(destino));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Destino> deleteDestino(@PathVariable long id){
        Destino destino = null;
        Optional<Destino> destinoOptional = repository.findById(id);
        if(destinoOptional.isPresent()){
            destino = destinoOptional.get();
            repository.deleteById(id);
        }
        return ResponseEntity.status(HttpStatus.OK).body(destino);
    }

}
