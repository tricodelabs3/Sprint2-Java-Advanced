package br.com.saudeinteligente.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class Clima {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClima;

    private String local;
    private LocalDateTime dataHora;
    private Double temperatura;
    private Double umidade;
    private String condicao;
}
