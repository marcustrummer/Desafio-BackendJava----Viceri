package br.com.desafioBackEndViceri.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	
	@NotNull(message = "O atributo nome é Obrigatório!") 
	@Size(min = 3, max = 100, message = "O atributo nome deve conter no mínimo 03 e no máximo 100 caracteres")
	private String name;

	
	@NotNull
	@Size(min = 2, max = 70, message = "O email deve conter ao menos 5 caracteres ex: email@hotmail.com")
	private String email;

	@NotNull
	@Size(min = 5)
	private String password;

	
	
	// relationship
	@OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("user")
	private List<Task> task;

	
	
	
	// ------------------------------------CRIANDO METODO CONSTRUTOR PARA TESTES
	public User(long id,String name , String email, String password) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	
	//-------------------------------------SEGUNDO METODO CONSTRUTOR------------------------
	public User() {	}
		
	
	// GETTERS AND SETTERS

	public String getEmail() {
		return email;
	}

	public List<Task> getTask() {
		return task;
	}

	public void setTask(List<Task> task) {
		this.task = task;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
