package br.com.desafioBackEndViceri.secutiry;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.desafioBackEndViceri.model.User;
import br.com.desafioBackEndViceri.repository.UserRepository;

@Service
public class UserDetailsServiceImpl  implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByEmail(userEmail);
		user.orElseThrow(() -> new UsernameNotFoundException(userEmail + "not found."));
		
		return user.map(UserDetailsImpl:: new).get();
	}

}


