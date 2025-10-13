package br.com.saudeinteligente.repository;

import br.com.saudeinteligente.model.Clima;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClimaRepository extends JpaRepository<Clima, Long> { }
