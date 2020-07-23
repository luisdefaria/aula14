package br.paduan.eventdashapi.service;

import java.util.List;

import br.paduan.eventdashapi.model.Usuario;

public interface IUsuarioService {
    public Usuario loginPorEmailOuRacf(Usuario usuario);
    public List<Usuario> listarTodos();
}