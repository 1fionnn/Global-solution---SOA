package com.example.upskillplatform.service;

import com.example.upskillplatform.entity.Trilha;
import com.example.upskillplatform.repository.TrilhaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrilhaService {

    private final TrilhaRepository repository;

    public TrilhaService(TrilhaRepository repository) {
        this.repository = repository;
    }

    public Trilha salvar(Trilha t) {
        return repository.save(t);
    }

    public List<Trilha> listarTodas() {
        return repository.findAll();
    }

    public Trilha buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trilha não encontrada"));
    }

    public Trilha atualizar(Long id, Trilha nova) {
        Trilha t = buscarPorId(id);
        t.setNome(nova.getNome());
        t.setDescricao(nova.getDescricao());
        t.setNivel(nova.getNivel());
        t.setCargaHoraria(nova.getCargaHoraria());
        t.setFocoPrincipal(nova.getFocoPrincipal());
        return repository.save(t);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
