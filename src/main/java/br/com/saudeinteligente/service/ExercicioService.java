package br.com.saudeinteligente.service;

import br.com.saudeinteligente.model.Exercicio;
import br.com.saudeinteligente.repository.ExercicioRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ExercicioService {
    private final ExercicioRepository repository;

    public ExercicioService(ExercicioRepository repository) {
        this.repository = repository;
    }

    public List<Exercicio> findAll() { return repository.findAll(); }
    public Exercicio findById(Long id) { return repository.findById(id).orElse(null); }
    public List<Exercicio> findByUsuario(Long usuarioId) { return repository.findByUsuario_IdUsuario(usuarioId); }
    public Exercicio save(Exercicio e) { return repository.save(e); }
    public void delete(Long id) { repository.deleteById(id); }
}
