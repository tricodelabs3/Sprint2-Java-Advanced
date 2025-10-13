package br.com.saudeinteligente.repository;

import br.com.saudeinteligente.model.Alimentacao;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AlimentacaoRepository extends JpaRepository<Alimentacao, Long> {
    List<Alimentacao> findByUsuario_IdUsuario(Long usuarioId);
}
