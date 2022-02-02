package br.com.viceri.dto.response;

import br.com.viceri.entity.Usuario;

public class UsuarioDto {
    private Long id;
    private String email;
    private String nome;

    public UsuarioDto(){
    }

    public UsuarioDto(Usuario usuario){
        this.id = usuario.getId();
        this.email = usuario.getEmail();
        this.nome = usuario.getNome();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
