package br.com.saudeinteligente.repository;

import br.com.saudeinteligente.model.Recomendacao;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RecomendacaoRepository extends JpaRepository<Recomendacao, Long> {
    List<Recomendacao> findByUsuario_IdUsuario(Long usuarioId);
}
