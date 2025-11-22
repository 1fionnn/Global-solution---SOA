package com.example.upskillplatform.controller;

import com.example.upskillplatform.entity.Trilha;
import com.example.upskillplatform.service.TrilhaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trilhas")
public class TrilhaController {

    private final TrilhaService service;

    public TrilhaController(TrilhaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Trilha> criar(@RequestBody Trilha t) {
        Trilha created = service.salvar(t);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    public List<Trilha> listar() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trilha> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Trilha> atualizar(@PathVariable Long id, @RequestBody Trilha t) {
        return ResponseEntity.ok(service.atualizar(id, t));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
