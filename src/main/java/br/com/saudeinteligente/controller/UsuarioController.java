package br.com.saudeinteligente.controller;

import br.com.saudeinteligente.dto.UsuarioDTO;
import br.com.saudeinteligente.model.Usuario;
import br.com.saudeinteligente.service.UsuarioService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping
    public List<UsuarioDTO> getAll() {
        return service.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public UsuarioDTO getById(@PathVariable Long id) {
        return toDTO(service.findById(id));
    }

    @PostMapping
    public Usuario create(@RequestBody Usuario usuario) {
        // Recebe entidade (com senha possivelmente) — retorno não expõe senha
        return service.save(usuario);
    }

    @PutMapping("/{id}")
    public Usuario update(@PathVariable Long id, @RequestBody Usuario usuario) {
        usuario.setIdUsuario(id);
        return service.save(usuario);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }

    private UsuarioDTO toDTO(Usuario u) {
        if (u == null) return null;
        UsuarioDTO dto = new UsuarioDTO();
        dto.setIdUsuario(u.getIdUsuario());
        dto.setNome(u.getNome());
        dto.setEmail(u.getEmail());
        dto.setDtNascimento(u.getDtNascimento());
        dto.setGenero(u.getGenero());
        return dto;
    }
}
