package com.redesocial.redesocial.controller;

import com.redesocial.redesocial.controller.dto.UsuarioDTO;
import com.redesocial.redesocial.controller.Form.UserForm;
import com.redesocial.redesocial.modelo.Usuario;
import com.redesocial.redesocial.repository.UsuarioRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuarios/")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<UsuarioDTO> inserir
            (@RequestBody UserForm UF,
             UriComponentsBuilder UB){

        Usuario usuario = UF.criaUsuario();
        usuarioRepository.save(usuario);
        UsuarioDTO usuarioDTO = new UsuarioDTO(usuario);
        UB.path("/usuarios/{id}");
        URI uri = UB.buildAndExpand(usuario.getId()).toUri();

        return ResponseEntity.created(uri).body(usuarioDTO);
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

    @GetMapping("/{id}")
    public ResponseEntity<?> listaUsuariosId(@PathVariable Integer id){

        try {

            Usuario usuario = usuarioRepository.getReferenceById(id);
            UsuarioDTO usuarioDTO = new UsuarioDTO(usuario);
            return ResponseEntity.ok(usuarioDTO);

        } catch (Exception e) {

            return ResponseEntity.notFound().build();

        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUsuario(@PathVariable Integer id,
                                                    @RequestBody UserForm UF){
        if (id == null){

            return ResponseEntity.badRequest().build();

        }

        try {

           Usuario usuario = usuarioRepository.getReferenceById(id);
           usuario.setNome(UF.getNome());
           usuario.setEmail(UF.getEmail());
           usuario.setSenha(UF.getSenha());
           usuarioRepository.save(usuario);
           UsuarioDTO usuarioDTO = new UsuarioDTO(usuario);

           return ResponseEntity.ok(usuarioDTO);

        } catch (Exception e) {

            return ResponseEntity.notFound().build();

        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletaUsuario(@PathVariable Integer id){

        if (id == null){

            return ResponseEntity.badRequest().build();

        }

        try {

            Usuario usuario = usuarioRepository.getReferenceById(id);
            usuarioRepository.delete(usuario);
            UsuarioDTO usuarioDTO = new UsuarioDTO(usuario);

            return ResponseEntity.ok(usuarioDTO);

        } catch (Exception e){

            return ResponseEntity.notFound().build();

        }

    }

}
