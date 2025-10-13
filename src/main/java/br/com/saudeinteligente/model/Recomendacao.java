package br.com.saudeinteligente.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Recomendacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRecomendacao;

    private String texto;
    private String geradoPor;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
