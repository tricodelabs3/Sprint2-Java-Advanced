package br.com.saudeinteligente.service;

import br.com.saudeinteligente.model.Sono;
import br.com.saudeinteligente.repository.SonoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SonoService {
    private final SonoRepository repository;

    public SonoService(SonoRepository repository) {
        this.repository = repository;
    }

    public List<Sono> findAll() { return repository.findAll(); }
    public Sono findById(Long id) { return repository.findById(id).orElse(null); }
    public List<Sono> findByUsuario(Long usuarioId) { return repository.findByUsuario_IdUsuario(usuarioId); }
    public Sono save(Sono sono) { return repository.save(sono); }
    public void delete(Long id) { repository.deleteById(id); }
}
