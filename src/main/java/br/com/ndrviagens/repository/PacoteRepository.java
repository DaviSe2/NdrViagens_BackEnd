package br.com.ndrviagens.repository;

import br.com.ndrviagens.model.Destino;
import br.com.ndrviagens.model.PacoteViagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

    @Repository
    public interface PacoteRepository extends JpaRepository<PacoteViagem, Long> {

        public List<Destino> findAllByNomeContainingIgnoreCase(String cidade);

    }

