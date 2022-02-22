 package br.com.desafioBackEndViceri.service;


import java.nio.charset.Charset;
import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.desafioBackEndViceri.model.User;
import br.com.desafioBackEndViceri.model.UserLogin;
import br.com.desafioBackEndViceri.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	public String encoder(String senha) {
		return encoder.encode(senha);
	}

	public List<User> listUsers() {
		return repository.findAll();
	}

	public Optional<User> findUserById(long id) {
		return repository.findById(id);
	}

	public Optional<User> createUser(User user) {
		if (repository.findByEmail(user.getEmail()).isPresent())
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O usuario ja existe!!", null);

		user.setPassword(encoder(user.getPassword()));

		return Optional.of(repository.save(user));
	}

	public Optional<UserLogin> login(Optional<UserLogin> user) {

		Optional<User> usuario = repository.findByEmail(user.get().getEmail());

		if (usuario.isPresent()) {
			if (encoder.matches(user.get().getPassword(), usuario.get().getPassword())) {

				String auth = user.get().getEmail() + ":" + user.get().getPassword();
				byte[] encodeAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodeAuth);

				user.get().setId(usuario.get().getId());
				user.get().setName(usuario.get().getName());
				user.get().setPassword(usuario.get().getPassword());
				user.get().setToken(authHeader);

				return user;
			}
		}
		throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Email ou Senha Inválidos!", null);
	}

	public Optional<User> updateUser(User user) {

		if (repository.findById(user.getId()).isPresent()) {

			Optional<User> buscaUsuario = repository.findByEmail(user.getEmail());

			if (buscaUsuario.isPresent()) {

				if (buscaUsuario.get().getId() != user.getId())
					throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O usuario já consta em nosso banco!", null);

			}

			return Optional.of(repository.save(user));
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario não encontrado!", null);
		}
	}

}
