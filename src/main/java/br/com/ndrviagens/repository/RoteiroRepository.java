package br.com.ndrviagens.repository;

import br.com.ndrviagens.model.RoteiroViagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoteiroRepository extends JpaRepository<RoteiroViagem, Long> {

    public <List>RoteiroViagem findAllByNomeRoteiro(String nomeRoteiro);

}
