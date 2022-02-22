package br.com.desafioBackEndViceri.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafioBackEndViceri.model.User;
import br.com.desafioBackEndViceri.model.UserLogin;
import br.com.desafioBackEndViceri.service.UserService;


@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/all")
	public ResponseEntity<List<User>> getAll(){
		return ResponseEntity.ok(userService.listUsers());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getById(@PathVariable long id){
		return userService.findUserById(id)
				.map(resp->ResponseEntity.status(HttpStatus.OK).body(resp))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<UserLogin> Autentication(@RequestBody Optional<UserLogin> user){
		return userService.login(user).map(resp-> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}
	
	@PostMapping("/register")
	public ResponseEntity<User> postUsuario(@RequestBody User user){
		return userService.createUser(user)
				.map(resp->ResponseEntity.status(HttpStatus.CREATED).body(resp))
				.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
	}
	
	@PutMapping("/update")
	public ResponseEntity<User> putUsuario(@RequestBody User user){
		return userService.updateUser(user)
				.map(resp->ResponseEntity.status(HttpStatus.OK).body(resp))
				.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
	}
	
	
	

	
	

}
