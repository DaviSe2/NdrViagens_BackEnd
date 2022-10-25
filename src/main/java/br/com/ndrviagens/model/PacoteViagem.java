package br.com.ndrviagens.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PacoteViagem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private boolean hospedagem;
    private boolean alimentacao;
    private boolean ingressos;

    @NotNull
    private String nome;

    @NotNull
    private BigDecimal preco;

    private BigDecimal precoPromo;

    @NotNull
    @OneToOne
    private Destino destino;

    @NotNull
    private String descricao;

}
