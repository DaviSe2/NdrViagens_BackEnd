package br.com.ndrviagens.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoteiroViagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String nomeRoteiro;

    @NotNull
    @ManyToMany
    @JsonProperty("pacotes_viagens")
    private List<PacoteViagem> pacotesViagens;

    private BigDecimal precoTotal;

    private BigDecimal precoPromoTotal;
}
