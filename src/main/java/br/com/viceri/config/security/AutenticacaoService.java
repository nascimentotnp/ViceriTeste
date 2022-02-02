package br.com.viceri.config.security;

import br.com.viceri.entity.Usuario;
import br.com.viceri.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository repository;

	@Override
	public UserDetails loadUserByUsername(String email) {
		Usuario usuario = repository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("Usuário inexistente"));
		String[] roles = new String[]{"ADMIN"};
		return User
				.builder()
				.authorities(new SimpleGrantedAuthority("ADMIN"))
				.username(usuario.getEmail())
				.password(usuario.getSenha())
				.disabled(false)
				.roles(roles)
				.build();

	}

}
