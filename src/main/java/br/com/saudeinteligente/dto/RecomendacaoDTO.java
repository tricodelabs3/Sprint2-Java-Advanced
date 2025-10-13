package br.com.saudeinteligente.dto;

import lombok.Data;

@Data
public class RecomendacaoDTO {
    private Long idRecomendacao;
    private String texto;
    private String geradoPor;
    private Long usuarioId;
}
