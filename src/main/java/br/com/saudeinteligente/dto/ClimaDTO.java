package br.com.saudeinteligente.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ClimaDTO {
    private Long idClima;
    private String local;
    private LocalDateTime dataHora;
    private Double temperatura;
    private Double umidade;
    private String condicao;
}
