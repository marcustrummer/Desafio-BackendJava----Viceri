package br.com.desafioBackEndViceri.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import br.com.desafioBackEndViceri.model.Task;
import br.com.desafioBackEndViceri.repository.TaskRepository;


@RestController
@RequestMapping("/tasks") 
@CrossOrigin(origins = "*", allowedHeaders = "*") 
public class TaskController {
	
	@Autowired 
	private TaskRepository taskRepository;
	
	@GetMapping
	public ResponseEntity<List<Task>> getAll (){
		return ResponseEntity.ok(taskRepository.findAll()); // OK = 200
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Task> getById(@PathVariable long id) {
		return taskRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/statusTask/{statusTask}")
	public ResponseEntity<List<Task>> getByStatus(@PathVariable String statusTask){
		return ResponseEntity.ok(taskRepository.findAllByStatusTaskContainingIgnoreCase(statusTask));
	}
	
	@GetMapping("/priority/{priority}")
	public ResponseEntity<List<Task>> getByPriority(@PathVariable String priority){
		return ResponseEntity.ok(taskRepository.findAllByPriorityContainingIgnoreCase(priority));
	}
	
//	@GetMapping(value = "/open")
//	public ResponseEntity<List<Task>> listOpen() {
//		List<Task> list = service.findAllOpen();
//		return ResponseEntity.ok().body(list);
//	}
	
	
	@PostMapping
	public ResponseEntity<Task> postTask(@RequestBody Task task){
		return ResponseEntity.status(HttpStatus.CREATED).body(taskRepository.save(task));
	}
	
	@PutMapping
	public ResponseEntity<Task> putTask(@RequestBody Task task){
		return ResponseEntity.status(HttpStatus.OK).body(taskRepository.save(task));
	}
	
	@DeleteMapping("/{id}")
	public void deleteTask(@PathVariable long id) {
		taskRepository.deleteById(id);
	}	
	

}
