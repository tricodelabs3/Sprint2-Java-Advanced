package br.com.saudeinteligente.controller;

import br.com.saudeinteligente.dto.SonoDTO;
import br.com.saudeinteligente.model.Sono;
import br.com.saudeinteligente.model.Usuario;
import br.com.saudeinteligente.service.SonoService;
import br.com.saudeinteligente.service.UsuarioService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/sono")
public class SonoController {

    private final SonoService service;
    private final UsuarioService usuarioService;

    public SonoController(SonoService service, UsuarioService usuarioService) {
        this.service = service;
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<SonoDTO> getAll() {
        return service.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public SonoDTO getById(@PathVariable Long id) {
        return toDTO(service.findById(id));
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<SonoDTO> getByUsuario(@PathVariable Long usuarioId) {
        return service.findByUsuario(usuarioId).stream().map(this::toDTO).collect(Collectors.toList());
    }

    @PostMapping
    public SonoDTO create(@RequestBody SonoDTO dto) {
        Sono s = toEntity(dto);
        Sono saved = service.save(s);
        return toDTO(saved);
    }

    @PutMapping("/{id}")
    public SonoDTO update(@PathVariable Long id, @RequestBody SonoDTO dto) {
        Sono s = toEntity(dto);
        s.setIdSono(id);
        return toDTO(service.save(s));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }

    private SonoDTO toDTO(Sono s) {
        if (s == null) return null;
        SonoDTO dto = new SonoDTO();
        dto.setIdSono(s.getIdSono());
        dto.setInicio(s.getInicio());
        dto.setFim(s.getFim());
        dto.setDuracao(s.getDuracao());
        dto.setObservacao(s.getObservacao());
        dto.setUsuarioId(s.getUsuario() != null ? s.getUsuario().getIdUsuario() : null);
        return dto;
    }

    private Sono toEntity(SonoDTO dto) {
        Sono s = new Sono();
        s.setInicio(dto.getInicio());
        s.setFim(dto.getFim());
        s.setDuracao(dto.getDuracao());
        s.setObservacao(dto.getObservacao());
        if (dto.getUsuarioId() != null) {
            Usuario u = usuarioService.findById(dto.getUsuarioId());
            s.setUsuario(u);
        }
        return s;
    }
}
