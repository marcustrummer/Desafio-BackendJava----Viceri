package br.com.desafioBackEndViceri.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafioBackEndViceri.model.User;

@Repository
public interface UserRepository extends JpaRepository <User, Long>{
	
	public Optional<User> findByEmail(String email);
	public User findByName(String name);
	public List<User> findAllByEmailContainingIgnoreCase(String email);

}
