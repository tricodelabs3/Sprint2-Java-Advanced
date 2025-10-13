package br.com.saudeinteligente.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class SonoDTO {
    private Long idSono;
    private LocalDateTime inicio;
    private LocalDateTime fim;
    private Integer duracao;
    private String observacao;
    private Long usuarioId;
}
