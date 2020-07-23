package br.paduan.eventdashapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.paduan.eventdashapi.model.Usuario;
import br.paduan.eventdashapi.service.IUsuarioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin(origins = "*")
@RestController
public class UsuarioController {

	@Autowired
	private IUsuarioService service;

	@PostMapping("/login")
	public ResponseEntity<Usuario> login(@RequestBody Usuario userIncomplete) {
		Usuario userFinded = service.loginPorEmailOuRacf(userIncomplete);
		if (userFinded != null) {
			return ResponseEntity.ok(userFinded);
		}
		return ResponseEntity.status(404).build(); // usuário não existe
	}

	@GetMapping(value="/usuarios")
	public ResponseEntity <List<Usuario>>
	listarTodos(){
		return ResponseEntity.ok(service.listarTodos());
	}	
	
	
	

}
