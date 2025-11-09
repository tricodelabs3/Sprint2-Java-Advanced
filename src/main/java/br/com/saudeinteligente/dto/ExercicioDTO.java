package br.com.saudeinteligente.dto;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;
import java.time.LocalTime;

@Data
public class ExercicioDTO extends RepresentationModel<ExercicioDTO> {
    private Long idExercicio;
    private String tipo;
    private LocalTime horaInicio;
    private Integer duracaoMin;
    private Integer calorias;
    private String observacao;
    private Long usuarioId;
}
