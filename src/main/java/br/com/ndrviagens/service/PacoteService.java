package br.com.ndrviagens.service;

import br.com.ndrviagens.model.Destino;
import br.com.ndrviagens.model.PacoteViagem;
import br.com.ndrviagens.repository.PacoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class PacoteService {

    @Autowired private PacoteRepository repository;

    private final BigDecimal porcentagemPromo = BigDecimal.valueOf(0.50);

    public List<PacoteViagem> getAllPacotes(){
        return repository.findAll();
    }

    public List<PacoteViagem> getPromo(){
        List<PacoteViagem> promocoes = repository.findAll();
        for(PacoteViagem elemento:promocoes){
            BigDecimal precoOriginal = elemento.getPreco();
            elemento.setPrecoPromo(precoOriginal.multiply(porcentagemPromo));
        }
        return promocoes;
    }

    public List<PacoteViagem> getDestaqueHome(){
        List<PacoteViagem> promocoes = repository.findAll();
        return promocoes.subList(0, 3);
    }

    public PacoteViagem savePacote(PacoteViagem novoPacote){
        novoPacote.setNome(novoPacote.getNome().toUpperCase());
        return repository.save(novoPacote);
    }

    public PacoteViagem deletePacote(long id){
        PacoteViagem pacoteViagem = null;
        Optional<PacoteViagem> pacoteViagemOptional = repository.findById(id);
        if(pacoteViagemOptional.isPresent()){
            pacoteViagem = pacoteViagemOptional.get();
            repository.deleteById(id);
        }
        return pacoteViagem;
    }

    public PacoteViagem getPacoteById(long id) {
        PacoteViagem pacoteViagem = null;
        Optional<PacoteViagem> pacoteViagemOptional = repository.findById(id);
        if (pacoteViagemOptional.isPresent()){
            pacoteViagem = pacoteViagemOptional.get();
        }
        return pacoteViagem;
    }

    public PacoteViagem updatePacote(PacoteViagem pacoteViagem) {
        return repository.save(pacoteViagem);
    }
}
