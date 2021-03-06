package br.com.viceri.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.viceri.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Optional<Usuario> findByEmail(String email);

}
