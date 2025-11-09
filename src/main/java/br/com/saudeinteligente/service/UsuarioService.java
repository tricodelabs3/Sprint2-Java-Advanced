package br.com.saudeinteligente.service;

import br.com.saudeinteligente.model.Usuario;
import br.com.saudeinteligente.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public List<Usuario> findAll() {
        return repository.findAll();
    }

    public Usuario findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Usuario save(Usuario usuario) {
        return repository.save(usuario);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    // 🔹 Novo método que usa a VIEW VW_RESUMO_SAUDE
    public List<Map<String, Object>> getResumoSaude() {
        List<Object[]> resultados = repository.findResumoSaude();
        return resultados.stream().map(obj -> {
            Map<String, Object> mapa = new HashMap<>();
            mapa.put("idUsuario", obj[0]);
            mapa.put("nome", obj[1]);
            mapa.put("totalMinSono", obj[2]);
            mapa.put("totalCalorias", obj[3]);
            return mapa;
        }).toList();
    }
}
