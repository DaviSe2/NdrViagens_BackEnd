package br.com.ndrviagens.service;

import br.com.ndrviagens.model.PacoteViagem;
import br.com.ndrviagens.model.RoteiroViagem;
import br.com.ndrviagens.repository.RoteiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoteiroService {

    @Autowired
    private RoteiroRepository roteiroRepository;
    @Autowired
    private PacoteService pacoteService;

    public List<RoteiroViagem> getAllRoteiroViagem(){
        List<RoteiroViagem> roteiroViagensSemPromo = roteiroRepository.findAll();
        List<RoteiroViagem> roteiroViagensComPromo = new ArrayList<>();
        for(int i = 0; i < roteiroViagensSemPromo.size(); i++){
            roteiroViagensComPromo.add(getRoteiroById(roteiroViagensSemPromo.get(i).getId()));
        }
        return roteiroViagensComPromo;
    }

    public RoteiroViagem getRoteiroById(long id) {
        RoteiroViagem roteiroViagem = null;
        BigDecimal precoTotal = new BigDecimal(0);
        BigDecimal precoPromoTotal = new BigDecimal(0);
        List<PacoteViagem> promoPacoteViagens = new ArrayList<>();
        Optional<RoteiroViagem> roteiroViagemOptional = roteiroRepository.findById(id);
        if (roteiroViagemOptional.isPresent()){
            roteiroViagem = roteiroViagemOptional.get();
            List<PacoteViagem> pacoteViagens = roteiroViagem.getPacotesViagens();
            for(int i = 0; i < pacoteViagens.size(); i++){
                promoPacoteViagens.add(pacoteService.getPromo(pacoteViagens.get(i).getId()));
                precoTotal = precoTotal.add(pacoteViagens.get(i).getPreco());
                precoPromoTotal = precoPromoTotal.add(pacoteViagens.get(i).getPrecoPromo());
            }
            roteiroViagem.setPrecoTotal(precoTotal);
            roteiroViagem.setPrecoPromoTotal(precoPromoTotal);
        }
        return roteiroViagem;
    }

    public RoteiroViagem saveRoteiro(RoteiroViagem roteiro){
        return roteiroRepository.save(roteiro);
    }

    public RoteiroViagem deleteRoteiro(long id){
        RoteiroViagem roteiroViagem = null;
        Optional<RoteiroViagem> roteiroViagemOptional = roteiroRepository.findById(id);
        if (roteiroViagemOptional.isPresent()){
            roteiroViagem = getRoteiroById(id);
            roteiroRepository.deleteById(id);
        }
        return roteiroViagem;
    }

    public RoteiroViagem updateRoteiro(RoteiroViagem roteiroViagem) {
        return roteiroRepository.save(roteiroViagem);
    }
}
