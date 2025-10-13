package br.com.saudeinteligente.controller;

import br.com.saudeinteligente.dto.RecomendacaoDTO;
import br.com.saudeinteligente.model.Recomendacao;
import br.com.saudeinteligente.model.Usuario;
import br.com.saudeinteligente.service.RecomendacaoService;
import br.com.saudeinteligente.service.UsuarioService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/recomendacoes")
public class RecomendacaoController {

    private final RecomendacaoService service;
    private final UsuarioService usuarioService;

    public RecomendacaoController(RecomendacaoService service, UsuarioService usuarioService) {
        this.service = service;
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<RecomendacaoDTO> getAll() {
        return service.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public RecomendacaoDTO getById(@PathVariable Long id) {
        return toDTO(service.findById(id));
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<RecomendacaoDTO> getByUsuario(@PathVariable Long usuarioId) {
        return service.findByUsuario(usuarioId).stream().map(this::toDTO).collect(Collectors.toList());
    }

    @PostMapping
    public RecomendacaoDTO create(@RequestBody RecomendacaoDTO dto) {
        Recomendacao r = toEntity(dto);
        return toDTO(service.save(r));
    }

    @PutMapping("/{id}")
    public RecomendacaoDTO update(@PathVariable Long id, @RequestBody RecomendacaoDTO dto) {
        Recomendacao r = toEntity(dto);
        r.setIdRecomendacao(id);
        return toDTO(service.save(r));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }

    private RecomendacaoDTO toDTO(Recomendacao r) {
        if (r == null) return null;
        RecomendacaoDTO dto = new RecomendacaoDTO();
        dto.setIdRecomendacao(r.getIdRecomendacao());
        dto.setTexto(r.getTexto());
        dto.setGeradoPor(r.getGeradoPor());
        dto.setUsuarioId(r.getUsuario() != null ? r.getUsuario().getIdUsuario() : null);
        return dto;
    }

    private Recomendacao toEntity(RecomendacaoDTO dto) {
        Recomendacao r = new Recomendacao();
        r.setTexto(dto.getTexto());
        r.setGeradoPor(dto.getGeradoPor());
        if (dto.getUsuarioId() != null) {
            Usuario u = usuarioService.findById(dto.getUsuarioId());
            r.setUsuario(u);
        }
        return r;
    }
}
