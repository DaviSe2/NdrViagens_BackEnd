package br.com.ndrviagens.service;

import br.com.ndrviagens.model.PacoteViagem;
import br.com.ndrviagens.repository.DestinoRepository;
import br.com.ndrviagens.repository.PacoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class PacoteService {

    @Autowired private PacoteRepository pacoteRepository;
    @Autowired private DestinoRepository destinoRepository;

    private final BigDecimal porcentagemPromo = BigDecimal.valueOf(0.50);

    public List<PacoteViagem> getAllPacotes(){
        return pacoteRepository.findAll();
    }

    public PacoteViagem getPromo(long id){
        PacoteViagem pacoteViagem = null;
        Optional<PacoteViagem> pacoteViagemOptional = pacoteRepository.findById(id);
        if (pacoteViagemOptional.isPresent()){
            pacoteViagem = pacoteViagemOptional.get();
            BigDecimal precoOriginal = pacoteViagem.getPreco();
            pacoteViagem.setPrecoPromo(precoOriginal.multiply(porcentagemPromo));
        }
        return pacoteViagem;
    }

    public List<PacoteViagem> getDestaqueHome(){
        List<PacoteViagem> promocoes = pacoteRepository.findAll();
        return promocoes.subList(0, 3);
    }

    public PacoteViagem savePacote(PacoteViagem novoPacote){
        Long idDestino = novoPacote.getDestino().getId();
        if (idDestino == 0){
            destinoRepository.save(novoPacote.getDestino());
        }
        novoPacote.setNome(novoPacote.getNome().toUpperCase());
        return pacoteRepository.save(novoPacote);
    }

    public PacoteViagem deletePacote(long id){
        PacoteViagem pacoteViagem = null;
        Optional<PacoteViagem> pacoteViagemOptional = pacoteRepository.findById(id);
        if(pacoteViagemOptional.isPresent()){
            pacoteViagem = pacoteViagemOptional.get();
            pacoteRepository.deleteById(id);
        }
        return pacoteViagem;
    }

    public PacoteViagem getPacoteById(long id) {
        PacoteViagem pacoteViagem = null;
        Optional<PacoteViagem> pacoteViagemOptional = pacoteRepository.findById(id);
        if (pacoteViagemOptional.isPresent()){
            pacoteViagem = pacoteViagemOptional.get();
        }
        return pacoteViagem;
    }

    public PacoteViagem updatePacote(PacoteViagem pacoteViagem) {
        return pacoteRepository.save(pacoteViagem);
    }
}
