package br.com.saudeinteligente.repository;

import br.com.saudeinteligente.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // 🔹 Consulta nativa usando a VIEW VW_RESUMO_SAUDE
    @Query(value = "SELECT id_usuario, nome, total_min_sono, total_calorias FROM VW_RESUMO_SAUDE", nativeQuery = true)
    List<Object[]> findResumoSaude();
}
