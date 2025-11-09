package br.com.saudeinteligente.dto;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;
import java.time.LocalDateTime;

@Data
public class SonoDTO extends RepresentationModel<SonoDTO> {
    private Long idSono;
    private LocalDateTime inicio;
    private LocalDateTime fim;
    private Integer duracao;
    private String observacao;
    private Long usuarioId;
}
