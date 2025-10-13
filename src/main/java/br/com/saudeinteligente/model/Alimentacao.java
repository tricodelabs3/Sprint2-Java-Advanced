package br.com.saudeinteligente.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalTime;

@Entity
@Data
public class Alimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAlimentacao;

    private LocalTime hora;
    private String descricao;
    private Integer calorias;
    private Integer proteinas;
    private Integer carboidratos;
    private String observacao;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
