package br.com.saudeinteligente.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalTime;

@Entity
@Data
public class Exercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idExercicio;

    private String tipo;
    private LocalTime horaInicio;
    private Integer duracaoMin;
    private Integer calorias;
    private String observacao;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
