package br.com.saudeinteligente.controller;

import br.com.saudeinteligente.dto.SonoDTO;
import br.com.saudeinteligente.model.Sono;
import br.com.saudeinteligente.model.Usuario;
import br.com.saudeinteligente.service.SonoService;
import br.com.saudeinteligente.service.UsuarioService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

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
        return service.findAll().stream().map(this::toDTOWithLinks).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public SonoDTO getById(@PathVariable Long id) {
        return toDTOWithLinks(service.findById(id));
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<SonoDTO> getByUsuario(@PathVariable Long usuarioId) {
        return service.findByUsuario(usuarioId).stream().map(this::toDTOWithLinks).collect(Collectors.toList());
    }

    @PostMapping
    public SonoDTO create(@RequestBody SonoDTO dto) {
        Sono s = toEntity(dto);
        return toDTOWithLinks(service.save(s));
    }

    @PutMapping("/{id}")
    public SonoDTO update(@PathVariable Long id, @RequestBody SonoDTO dto) {
        Sono s = toEntity(dto);
        s.setIdSono(id);
        return toDTOWithLinks(service.save(s));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    private SonoDTO toDTOWithLinks(Sono s) {
        if (s == null) return null;
        SonoDTO dto = new SonoDTO();
        dto.setIdSono(s.getIdSono());
        dto.setInicio(s.getInicio());
        dto.setFim(s.getFim());
        dto.setDuracao(s.getDuracao());
        dto.setObservacao(s.getObservacao());
        dto.setUsuarioId(s.getUsuario() != null ? s.getUsuario().getIdUsuario() : null);

        dto.add(linkTo(methodOn(SonoController.class).getById(s.getIdSono())).withSelfRel());
        dto.add(linkTo(methodOn(SonoController.class).getAll()).withRel("allSono"));
        if (s.getUsuario() != null)
            dto.add(linkTo(methodOn(UsuarioController.class).getById(s.getUsuario().getIdUsuario())).withRel("usuario"));
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
