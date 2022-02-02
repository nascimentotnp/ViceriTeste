package br.com.viceri.service;

import br.com.viceri.dto.request.UsuarioForm;
import br.com.viceri.dto.response.UsuarioDto;

public interface UsuarioService {
    UsuarioDto create(UsuarioForm form);
}
