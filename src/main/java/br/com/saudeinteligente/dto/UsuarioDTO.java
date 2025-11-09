package br.com.saudeinteligente.dto;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;
import java.time.LocalDate;

@Data
public class UsuarioDTO extends RepresentationModel<UsuarioDTO> {

    private Long idUsuario;
    private String nome;
    private String email;
    private LocalDate dtNascimento;
    private String genero;

    public UsuarioDTO() {}

    public UsuarioDTO(Long idUsuario, String nome, String email, LocalDate dtNascimento, String genero) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.email = email;
        this.dtNascimento = dtNascimento;
        this.genero = genero;
    }
}
