package br.com.saudeinteligente.dto;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

@Data
public class RecomendacaoDTO extends RepresentationModel<RecomendacaoDTO> {
    private Long idRecomendacao;
    private String texto;
    private String geradoPor;
    private Long usuarioId;
}
