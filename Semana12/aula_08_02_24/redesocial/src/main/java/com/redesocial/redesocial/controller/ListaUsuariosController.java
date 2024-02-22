package com.redesocial.redesocial.controller;

import com.redesocial.redesocial.controller.dto.UsuarioDTO;
import com.redesocial.redesocial.modelo.Usuario;
import com.redesocial.redesocial.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ListaUsuariosController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @RequestMapping("/listausuarios/")
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
