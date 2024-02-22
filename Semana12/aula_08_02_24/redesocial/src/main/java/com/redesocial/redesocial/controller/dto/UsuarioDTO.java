package com.redesocial.redesocial.controller.dto;

import com.redesocial.redesocial.modelo.Usuario;

public class UsuarioDTO {

    private Long Id;
    private String Nome;
    private String Email;

    public UsuarioDTO(Usuario usuario){

        this.Id = usuario.getId();
        this.Nome = usuario.getNome();
        this.Email = usuario.getEmail();

    }

    public Long getId() {
        return Id;
    }

    public String getNome() {
        return Nome;
    }

    public String getEmail() {
        return Email;
    }
}
