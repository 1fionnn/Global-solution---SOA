package com.example.upskillplatform.service;

import com.example.upskillplatform.entity.Usuario;
import com.example.upskillplatform.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Usuario salvar(Usuario u) {
        u.setDataCadastro(LocalDate.now());
        return repository.save(u);
    }

    public List<Usuario> listarTodos() {
        return repository.findAll();
    }

    public Usuario buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public Usuario atualizar(Long id, Usuario novo) {
        Usuario u = buscarPorId(id);
        u.setNome(novo.getNome());
        u.setEmail(novo.getEmail());
        u.setAreaAtuacao(novo.getAreaAtuacao());
        u.setNivelCarreira(novo.getNivelCarreira());
        return repository.save(u);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
