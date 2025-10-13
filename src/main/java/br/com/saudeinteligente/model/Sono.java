package br.com.saudeinteligente.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class Sono {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSono;

    private LocalDateTime inicio;
    private LocalDateTime fim;
    private Integer duracao;
    private String observacao;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
