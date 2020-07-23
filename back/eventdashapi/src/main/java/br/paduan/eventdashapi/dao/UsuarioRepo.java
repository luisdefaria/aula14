package br.paduan.eventdashapi.dao;

import org.springframework.data.repository.CrudRepository;

import br.paduan.eventdashapi.model.Usuario;

public interface UsuarioRepo extends CrudRepository<Usuario, Integer>{

	//JPA gera automatico nao precisa implementar na interface
	public Usuario findByEmailAndSenha(String email, String senha);
	//JAP gera automatico
	public Usuario findByRacfAndSenha(String racf, String senha);
	//JAP gera automatico
	public Usuario findByEmailOrRacf(String email, String racf);
	
}
