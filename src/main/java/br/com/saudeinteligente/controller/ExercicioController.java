package br.com.saudeinteligente.controller;

import br.com.saudeinteligente.dto.ExercicioDTO;
import br.com.saudeinteligente.model.Exercicio;
import br.com.saudeinteligente.model.Usuario;
import br.com.saudeinteligente.service.ExercicioService;
import br.com.saudeinteligente.service.UsuarioService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/exercicios")
public class ExercicioController {

    private final ExercicioService service;
    private final UsuarioService usuarioService;

    public ExercicioController(ExercicioService service, UsuarioService usuarioService) {
        this.service = service;
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<ExercicioDTO> getAll() {
        return service.findAll().stream().map(this::toDTOWithLinks).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ExercicioDTO getById(@PathVariable Long id) {
        return toDTOWithLinks(service.findById(id));
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<ExercicioDTO> getByUsuario(@PathVariable Long usuarioId) {
        return service.findByUsuario(usuarioId).stream().map(this::toDTOWithLinks).collect(Collectors.toList());
    }

    @PostMapping
    public ExercicioDTO create(@RequestBody ExercicioDTO dto) {
        return toDTOWithLinks(service.save(toEntity(dto)));
    }

    @PutMapping("/{id}")
    public ExercicioDTO update(@PathVariable Long id, @RequestBody ExercicioDTO dto) {
        Exercicio e = toEntity(dto);
        e.setIdExercicio(id);
        return toDTOWithLinks(service.save(e));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    private ExercicioDTO toDTOWithLinks(Exercicio e) {
        if (e == null) return null;
        ExercicioDTO dto = new ExercicioDTO();
        dto.setIdExercicio(e.getIdExercicio());
        dto.setTipo(e.getTipo());
        dto.setHoraInicio(e.getHoraInicio());
        dto.setDuracaoMin(e.getDuracaoMin());
        dto.setCalorias(e.getCalorias());
        dto.setObservacao(e.getObservacao());
        dto.setUsuarioId(e.getUsuario() != null ? e.getUsuario().getIdUsuario() : null);

        dto.add(linkTo(methodOn(ExercicioController.class).getById(e.getIdExercicio())).withSelfRel());
        dto.add(linkTo(methodOn(ExercicioController.class).getAll()).withRel("allExercicios"));
        if (e.getUsuario() != null)
            dto.add(linkTo(methodOn(UsuarioController.class).getById(e.getUsuario().getIdUsuario())).withRel("usuario"));
        return dto;
    }

    private Exercicio toEntity(ExercicioDTO dto) {
        Exercicio e = new Exercicio();
        e.setTipo(dto.getTipo());
        e.setHoraInicio(dto.getHoraInicio());
        e.setDuracaoMin(dto.getDuracaoMin());
        e.setCalorias(dto.getCalorias());
        e.setObservacao(dto.getObservacao());
        if (dto.getUsuarioId() != null) {
            Usuario u = usuarioService.findById(dto.getUsuarioId());
            e.setUsuario(u);
        }
        return e;
    }
}
