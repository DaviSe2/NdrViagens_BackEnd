package br.com.ndrviagens.repository;

import br.com.ndrviagens.model.Destino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DestinoRepository extends JpaRepository<Destino, Long> {

    public List<Destino> findAllByCidadeContainingIgnoreCase(String cidade);

}
