package br.com.saudeinteligente.dto;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;
import java.time.LocalDateTime;

@Data
public class ClimaDTO extends RepresentationModel<ClimaDTO> {
    private Long idClima;
    private String local;
    private LocalDateTime dataHora;
    private Double temperatura;
    private Double umidade;
    private String condicao;
}
