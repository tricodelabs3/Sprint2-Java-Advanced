package br.com.saudeinteligente.dto;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;
import java.time.LocalTime;

@Data
public class AlimentacaoDTO extends RepresentationModel<AlimentacaoDTO> {
    private Long idAlimentacao;
    private LocalTime hora;
    private String descricao;
    private Integer calorias;
    private Integer proteinas;
    private Integer carboidratos;
    private String observacao;
    private Long usuarioId;
}
