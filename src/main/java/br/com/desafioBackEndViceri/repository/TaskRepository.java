package br.com.desafioBackEndViceri.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.desafioBackEndViceri.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{
	
//	@Query("SELECT tb_tasks FROM Task obj WHERE obj.finalizado = false ORDER BY obj.dataParaFinalizar")
//	public List <Task> findAllByPriority();
	public List <Task> findAllByStatusTaskContainingIgnoreCase(String statusTask);
	public List <Task> findAllByPriorityContainingIgnoreCase(String priority);
}
