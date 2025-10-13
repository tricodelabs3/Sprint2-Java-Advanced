package br.com.saudeinteligente.service;

import br.com.saudeinteligente.model.Alimentacao;
import br.com.saudeinteligente.repository.AlimentacaoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AlimentacaoService {
    private final AlimentacaoRepository repository;

    public AlimentacaoService(AlimentacaoRepository repository) {
        this.repository = repository;
    }

    public List<Alimentacao> findAll() { return repository.findAll(); }
    public Alimentacao findById(Long id) { return repository.findById(id).orElse(null); }
    public List<Alimentacao> findByUsuario(Long usuarioId) { return repository.findByUsuario_IdUsuario(usuarioId); }
    public Alimentacao save(Alimentacao a) { return repository.save(a); }
    public void delete(Long id) { repository.deleteById(id); }
}
