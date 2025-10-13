package br.com.saudeinteligente.service;

import br.com.saudeinteligente.model.Clima;
import br.com.saudeinteligente.repository.ClimaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClimaService {
    private final ClimaRepository repository;

    public ClimaService(ClimaRepository repository) {
        this.repository = repository;
    }

    public List<Clima> findAll() { return repository.findAll(); }
    public Clima findById(Long id) { return repository.findById(id).orElse(null); }
    public Clima save(Clima c) { return repository.save(c); }
    public void delete(Long id) { repository.deleteById(id); }
}
