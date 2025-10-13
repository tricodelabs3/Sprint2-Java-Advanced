package br.com.saudeinteligente.repository;

import br.com.saudeinteligente.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> { }
