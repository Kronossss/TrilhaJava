package com.redesocial.redesocial.controller;

import com.redesocial.redesocial.controller.dto.UsuarioDTO;
import com.redesocial.redesocial.controller.form.UsuarioForm;
import com.redesocial.redesocial.modelo.Usuario;
import com.redesocial.redesocial.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuario/")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @PostMapping
    public UsuarioDTO inserir(@RequestBody UsuarioForm UF){
        Usuario usuario = UF.criaUsuario();
        usuarioRepository.save(usuario);
        return new UsuarioDTO(usuario);

    }
    @GetMapping
    public List<UsuarioDTO> retornaUsuarios(String name){
        List<Usuario> listaUsuarios = (ArrayList<Usuario>) usuarioRepository.findAll();
        List<UsuarioDTO> lista = new ArrayList<UsuarioDTO>();
        for (Usuario u : listaUsuarios){

            UsuarioDTO ud = new UsuarioDTO(u);
            lista.add(ud);

        }


        return lista;
    }
}
