package br.com.ndrviagens.model;

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
@Table(name = "Pacotes")
public class PacoteViagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "Hospedagem")
    private boolean hospedagem;

    @Column(name = "Alimentacao")
    private boolean alimentacao;

    @Column(name = "Ingressos")
    private boolean ingressos;

    @NotNull
    @Column(name = "Nome")
    private String nome;

    @NotNull
    @Column(name = "Preco")
    private BigDecimal preco;

    @Column(name = "Preco_Promo")
    private BigDecimal precoPromo ;

    @NotNull
    @OneToOne
    @JoinColumn(name = "Destino_ID")
    private Destino destino;

    @NotNull
    @Column(name = "Descricao")
    private String descricao;

}
