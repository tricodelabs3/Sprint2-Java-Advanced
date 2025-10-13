package br.com.saudeinteligente.service;

import br.com.saudeinteligente.model.Usuario;
import br.com.saudeinteligente.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public List<Usuario> findAll() { return repository.findAll(); }
    public Usuario findById(Long id) { return repository.findById(id).orElse(null); }
    public Usuario save(Usuario usuario) { return repository.save(usuario); }
    public void delete(Long id) { repository.deleteById(id); }
}
