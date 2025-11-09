package br.com.saudeinteligente.controller;

import br.com.saudeinteligente.dto.AlimentacaoDTO;
import br.com.saudeinteligente.model.Alimentacao;
import br.com.saudeinteligente.model.Usuario;
import br.com.saudeinteligente.service.AlimentacaoService;
import br.com.saudeinteligente.service.UsuarioService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/alimentacao")
public class AlimentacaoController {

    private final AlimentacaoService service;
    private final UsuarioService usuarioService;

    public AlimentacaoController(AlimentacaoService service, UsuarioService usuarioService) {
        this.service = service;
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<AlimentacaoDTO> getAll() {
        return service.findAll().stream().map(this::toDTOWithLinks).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public AlimentacaoDTO getById(@PathVariable Long id) {
        return toDTOWithLinks(service.findById(id));
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<AlimentacaoDTO> getByUsuario(@PathVariable Long usuarioId) {
        return service.findByUsuario(usuarioId).stream().map(this::toDTOWithLinks).collect(Collectors.toList());
    }

    @PostMapping
    public AlimentacaoDTO create(@RequestBody AlimentacaoDTO dto) {
        return toDTOWithLinks(service.save(toEntity(dto)));
    }

    @PutMapping("/{id}")
    public AlimentacaoDTO update(@PathVariable Long id, @RequestBody AlimentacaoDTO dto) {
        Alimentacao a = toEntity(dto);
        a.setIdAlimentacao(id);
        return toDTOWithLinks(service.save(a));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    private AlimentacaoDTO toDTOWithLinks(Alimentacao a) {
        if (a == null) return null;
        AlimentacaoDTO dto = new AlimentacaoDTO();
        dto.setIdAlimentacao(a.getIdAlimentacao());
        dto.setHora(a.getHora());
        dto.setDescricao(a.getDescricao());
        dto.setCalorias(a.getCalorias());
        dto.setProteinas(a.getProteinas());
        dto.setCarboidratos(a.getCarboidratos());
        dto.setObservacao(a.getObservacao());
        dto.setUsuarioId(a.getUsuario() != null ? a.getUsuario().getIdUsuario() : null);

        dto.add(linkTo(methodOn(AlimentacaoController.class).getById(a.getIdAlimentacao())).withSelfRel());
        dto.add(linkTo(methodOn(AlimentacaoController.class).getAll()).withRel("allAlimentacao"));
        if (a.getUsuario() != null)
            dto.add(linkTo(methodOn(UsuarioController.class).getById(a.getUsuario().getIdUsuario())).withRel("usuario"));
        return dto;
    }

    private Alimentacao toEntity(AlimentacaoDTO dto) {
        Alimentacao a = new Alimentacao();
        a.setHora(dto.getHora());
        a.setDescricao(dto.getDescricao());
        a.setCalorias(dto.getCalorias());
        a.setProteinas(dto.getProteinas());
        a.setCarboidratos(dto.getCarboidratos());
        a.setObservacao(dto.getObservacao());
        if (dto.getUsuarioId() != null) {
            Usuario u = usuarioService.findById(dto.getUsuarioId());
            a.setUsuario(u);
        }
        return a;
    }
}
