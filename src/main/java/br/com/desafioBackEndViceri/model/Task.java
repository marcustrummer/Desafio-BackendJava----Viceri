package br.com.desafioBackEndViceri.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_tasks")
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(min = 10)
	private String title;
	
	
	@NotNull
	@Size(min=5, max=5, message="O atributo prioridade deve ser categorizado entre Alta Media e Baixa")
	private String priority;
	
	
	@NotNull(message = "O atributo descricao eh obrigatorio!")
	@Size(min=5, max=1000, message="O atributo descricao deve ter no minimo 5 e no maximo 1000 caracteres")
	private String description;
	
	
	@NotNull(message = "O atributo descricao eh obrigatorio e deve ser categorizado em Pendente e Concluido")
	@Size(min= 8, max = 9)
	private String statusTask;


	@ManyToOne
	@JsonIgnoreProperties("task")
	private User user;
	
	
	
	
	//GETTERS AND SETTERS
	


	public String getTitle() {
		return title;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getStatusTask() {
		return statusTask;
	}

	public void setStatusTask(String statusTask) {
		this.statusTask = statusTask;
	}




	
}
