package br.com.desafioBackEndViceri.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafioBackEndViceri.model.Task;
import br.com.desafioBackEndViceri.repository.TaskRepository;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository taskRepository;
	
	public Task findById(long id) {
		Optional<Task> obj = taskRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado!! Id: " + id + 
				", tipo: " + Task.class.getName(), null));
	}
	
	public List<Task> findAllOpen(){
		List<Task> list = taskRepository.findAllOpen();
		return list;
	}
	
	public List<Task> findAllClose(){
		List<Task> list = taskRepository.findAllClose();
		return list;
	}

	public List<Task> findAll() {
		List<Task> list = taskRepository.findAll();
		return list;
	}

	public Task create(Task obj) {
		obj.setId(0);
		return taskRepository.save(obj);
	}
	
	public Task update(Integer id, Task obj) {
		Task newObj = findById(id);
		
		
		newObj.setTitle(obj.getTitle());
		newObj.setDescription(obj.getDescription());
		newObj.setFinalizado(obj.getFinalizado());
		return taskRepository.save(newObj);
	}
	

	public void delete(long id) {
		taskRepository.deleteById(id);
	}

	
	
	

}
