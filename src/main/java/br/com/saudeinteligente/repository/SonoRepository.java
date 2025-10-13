package br.com.saudeinteligente.repository;

import br.com.saudeinteligente.model.Sono;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SonoRepository extends JpaRepository<Sono, Long> {
    List<Sono> findByUsuario_IdUsuario(Long usuarioId);
}
