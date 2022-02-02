package br.com.viceri.controller;

import br.com.viceri.dto.request.UsuarioForm;
import br.com.viceri.dto.response.UsuarioDto;
import br.com.viceri.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioDto> create(@RequestBody UsuarioForm form){
        return new ResponseEntity<>(this.usuarioService.create(form), HttpStatus.CREATED);
    }

}
