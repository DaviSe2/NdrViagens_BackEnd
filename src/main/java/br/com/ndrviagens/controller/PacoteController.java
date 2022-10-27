package br.com.ndrviagens.controller;

import br.com.ndrviagens.model.PacoteViagem;
import br.com.ndrviagens.service.PacoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pacotes")
@CrossOrigin("*")
public class PacoteController {

    @Autowired
    private PacoteService service;

    @GetMapping
    public ResponseEntity<List<PacoteViagem>> getAllPacotes(){
        return ResponseEntity.ok().body(service.getAllPacotes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacoteViagem> getPacoteById(@PathVariable long id){
        return ResponseEntity.ok().body(service.getPacoteById(id));
    }

    @PostMapping
    public ResponseEntity<PacoteViagem> saveDestino(@RequestBody PacoteViagem pacote){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.savePacote(pacote));
    }

    @GetMapping("/promocoes/{id}")
    public ResponseEntity<PacoteViagem> getPromocoes(@PathVariable long id){
        return ResponseEntity.ok().body(service.getPromo(id));
    }

    @GetMapping("/destaques")
    public ResponseEntity<List<PacoteViagem>> getDestaques(){
        return ResponseEntity.ok().body(service.getDestaqueHome());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PacoteViagem> deletePacote(@PathVariable long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.deletePacote(id));
    }

    @PatchMapping
    public ResponseEntity<PacoteViagem> updatePacote(@RequestBody PacoteViagem pacoteViagem) {
        return ResponseEntity.status(HttpStatus.OK).body(service.updatePacote(pacoteViagem));
    }
}
