package com.redesocial.redesocial.controller.form;

import com.redesocial.redesocial.modelo.Usuario;

public class UsuarioForm {
    String nome;
    String senha;
    String email;

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public String getEmail() {
        return email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Usuario criaUsuario(){
        return new Usuario(null, nome, senha, email);
    }

}


