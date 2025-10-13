package br.com.saudeinteligente.service;

import br.com.saudeinteligente.model.Recomendacao;
import br.com.saudeinteligente.repository.RecomendacaoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RecomendacaoService {
    private final RecomendacaoRepository repository;

    public RecomendacaoService(RecomendacaoRepository repository) {
        this.repository = repository;
    }

    public List<Recomendacao> findAll() { return repository.findAll(); }
    public Recomendacao findById(Long id) { return repository.findById(id).orElse(null); }
    public List<Recomendacao> findByUsuario(Long usuarioId) { return repository.findByUsuario_IdUsuario(usuarioId); }
    public Recomendacao save(Recomendacao r) { return repository.save(r); }
    public void delete(Long id) { repository.deleteById(id); }
}
