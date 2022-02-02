package br.com.viceri.service.impl;

import br.com.viceri.dto.request.UsuarioForm;
import br.com.viceri.dto.response.UsuarioDto;
import br.com.viceri.entity.Usuario;
import br.com.viceri.repository.UsuarioRepository;
import br.com.viceri.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UsuarioDto create(UsuarioForm form){
        Usuario usuario = new Usuario(form);
        String senhaCriptografada = passwordEncoder.encode(form.getSenha());
        usuario.setSenha(senhaCriptografada);
        return new UsuarioDto(repository.save(usuario));
    }

}
