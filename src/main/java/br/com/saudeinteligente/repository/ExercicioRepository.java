package br.com.saudeinteligente.repository;

import br.com.saudeinteligente.model.Exercicio;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ExercicioRepository extends JpaRepository<Exercicio, Long> {
    List<Exercicio> findByUsuario_IdUsuario(Long usuarioId);
}
