package br.com.saudeinteligente.controller;

import br.com.saudeinteligente.dto.ClimaDTO;
import br.com.saudeinteligente.model.Clima;
import br.com.saudeinteligente.service.ClimaService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/clima")
public class ClimaController {

    private final ClimaService service;

    public ClimaController(ClimaService service) {
        this.service = service;
    }

    @GetMapping
    public List<ClimaDTO> getAll() {
        return service.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ClimaDTO getById(@PathVariable Long id) {
        return toDTO(service.findById(id));
    }

    @PostMapping
    public ClimaDTO create(@RequestBody ClimaDTO dto) {
        Clima c = toEntity(dto);
        return toDTO(service.save(c));
    }

    @PutMapping("/{id}")
    public ClimaDTO update(@PathVariable Long id, @RequestBody ClimaDTO dto) {
        Clima c = toEntity(dto);
        c.setIdClima(id);
        return toDTO(service.save(c));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }

    private ClimaDTO toDTO(Clima c) {
        if (c == null) return null;
        ClimaDTO dto = new ClimaDTO();
        dto.setIdClima(c.getIdClima());
        dto.setLocal(c.getLocal());
        dto.setDataHora(c.getDataHora());
        dto.setTemperatura(c.getTemperatura());
        dto.setUmidade(c.getUmidade());
        dto.setCondicao(c.getCondicao());
        return dto;
    }

    private Clima toEntity(ClimaDTO dto) {
        Clima c = new Clima();
        c.setLocal(dto.getLocal());
        c.setDataHora(dto.getDataHora());
        c.setTemperatura(dto.getTemperatura());
        c.setUmidade(dto.getUmidade());
        c.setCondicao(dto.getCondicao());
        return c;
    }
}
