package br.com.desafioBackEndViceri.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.desafioBackEndViceri.model.Task;
import br.com.desafioBackEndViceri.service.TaskService;


@RestController
@RequestMapping("/tasks") 
@CrossOrigin(origins = "*", allowedHeaders = "*") 
public class TaskController {
	
	@Autowired 
	private TaskService service;
	
	@GetMapping
	public ResponseEntity<List<Task>> lisAll() {
		List<Task> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Task> findById(@PathVariable Integer id) {
		Task obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping(value = "/open")
	public ResponseEntity<List<Task>> listOpen() {
		List<Task> list = service.findAllOpen();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/close")
	public ResponseEntity<List<Task>> listClose() {
		List<Task> list = service.findAllClose();
		return ResponseEntity.ok().body(list);
	}

	@PostMapping
	public ResponseEntity<Task> create(@RequestBody Task obj) {
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);// == .build()
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Task> update(@PathVariable Integer id, @RequestBody Task obj){
		Task newObj = service.update(id, obj);	
		return ResponseEntity.ok().body(newObj);
		
	}
	

}
