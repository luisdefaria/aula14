package br.paduan.eventdashapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.paduan.eventdashapi.dao.UsuarioRepo;
import br.paduan.eventdashapi.model.Usuario;

@Component
public class UsuarioServiceImp implements IUsuarioService {

    @Autowired
    UsuarioRepo repo;

    @Override
    public Usuario loginPorEmailOuRacf(Usuario usuario) {
        Usuario findedUser = repo.findByEmailOrRacf(usuario.getEmail(), usuario.getRacf());

        if (findedUser != null) {
            if (usuario.getSenha().equals(findedUser.getSenha())) {
                findedUser.setSenha("*******");
                return findedUser;
            }
        }

        return null;
    }

    @Override
    public List<Usuario> listarTodos() {
        return (List<Usuario>) repo.findAll();
    }

    


    
}