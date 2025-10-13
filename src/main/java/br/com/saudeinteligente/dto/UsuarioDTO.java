package br.com.saudeinteligente.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class UsuarioDTO {
    private Long idUsuario;
    private String nome;
    private String email;
    private LocalDate dtNascimento;
    private String genero;
}
