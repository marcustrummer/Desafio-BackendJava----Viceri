package br.com.desafioBackEndViceri.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_tasks")
public class Task implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message = "O atributo title eh obrigatorio!")
	@Size(min = 10)
	private String title;
	
	
	@NotNull(message = "O atributo prioridade nao pode ser nulo e deve ser categorizado 1-> 3 1-Alta, 2-Media, 3-Baixa")
	private int priority;
	
	
	@NotNull(message = "O atributo descricao eh obrigatorio!")
	@Size(min=5, max=1000, message="O atributo descricao deve ter no minimo 5 e no maximo 1000 caracteres")
	private String description;
	
	private Boolean finalizado = false;


	public Task() {
		super();
	}
	
	public Task(long id, String title, String description, Boolean finalizado) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.finalizado = finalizado;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		return id == other.id;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//relationship
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



	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
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

	public Boolean getFinalizado() {
		return finalizado;
	}

	public void setFinalizado(Boolean finalizado) {
		this.finalizado = finalizado;
	}





	
}
