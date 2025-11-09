package br.com.saudeinteligente.controller;

import br.com.saudeinteligente.dto.UsuarioDTO;
import br.com.saudeinteligente.model.Usuario;
import br.com.saudeinteligente.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    @Autowired
    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    // 🔹 GET - Lista todos os usuários
    @GetMapping
    public List<UsuarioDTO> getAll() {
        return service.findAll().stream().map(usuario -> {
            UsuarioDTO dto = new UsuarioDTO(
                    usuario.getIdUsuario(),
                    usuario.getNome(),
                    usuario.getEmail(),
                    usuario.getDtNascimento(),
                    usuario.getGenero()
            );
            dto.add(linkTo(methodOn(UsuarioController.class).getById(dto.getIdUsuario())).withSelfRel());
            dto.add(linkTo(methodOn(UsuarioController.class).getAll()).withRel("allUsuarios"));
            return dto;
        }).collect(Collectors.toList());
    }

    // 🔹 GET - Busca um usuário por ID
    @GetMapping("/{id}")
    public UsuarioDTO getById(@PathVariable Long id) {
        Usuario usuario = service.findById(id);
        UsuarioDTO dto = new UsuarioDTO(
                usuario.getIdUsuario(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getDtNascimento(),
                usuario.getGenero()
        );
        dto.add(linkTo(methodOn(UsuarioController.class).getById(id)).withSelfRel());
        dto.add(linkTo(methodOn(UsuarioController.class).getAll()).withRel("allUsuarios"));
        return dto;
    }

    // 🔹 POST - Cria um novo usuário
    @PostMapping
    public UsuarioDTO create(@RequestBody Usuario usuario) {
        Usuario novo = service.save(usuario);
        UsuarioDTO dto = new UsuarioDTO(
                novo.getIdUsuario(),
                novo.getNome(),
                novo.getEmail(),
                novo.getDtNascimento(),
                novo.getGenero()
        );
        dto.add(linkTo(methodOn(UsuarioController.class).getById(dto.getIdUsuario())).withSelfRel());
        dto.add(linkTo(methodOn(UsuarioController.class).getAll()).withRel("allUsuarios"));
        return dto;
    }

    // 🔹 PUT - Atualiza um usuário
    @PutMapping("/{id}")
    public UsuarioDTO update(@PathVariable Long id, @RequestBody Usuario usuario) {
        usuario.setIdUsuario(id);
        Usuario atualizado = service.save(usuario);
        UsuarioDTO dto = new UsuarioDTO(
                atualizado.getIdUsuario(),
                atualizado.getNome(),
                atualizado.getEmail(),
                atualizado.getDtNascimento(),
                atualizado.getGenero()
        );
        dto.add(linkTo(methodOn(UsuarioController.class).getById(id)).withSelfRel());
        dto.add(linkTo(methodOn(UsuarioController.class).getAll()).withRel("allUsuarios"));
        return dto;
    }

    // 🔹 DELETE - Exclui um usuário
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Usuário deletado com sucesso!";
    }
}
