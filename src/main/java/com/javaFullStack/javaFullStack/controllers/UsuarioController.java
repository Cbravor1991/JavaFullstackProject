package com.javaFullStack.javaFullStack.controllers;

import com.javaFullStack.javaFullStack.models.Usuario;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {

    @RequestMapping(value = "usuario/{id}")
    public Usuario getUsuario(@PathVariable Long id){
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombre("Christian");
        usuario.setApellido("Reyes");
        usuario.setEmail("christian@gmail.com");
        usuario.setTelefono("23456");
        return usuario;
    }

    @RequestMapping(value = "usuarios")
    public List<Usuario> getUsuario(){
        List<Usuario> usuarios = new ArrayList<>();
        Usuario usuario = new Usuario();
        usuario.setId(7L);
        usuario.setNombre("Christian");
        usuario.setApellido("Reyes");
        usuario.setEmail("christian@gmail.com");
        usuario.setTelefono("23456");

        Usuario usuario2 = new Usuario();
        usuario2.setId(12L);
        usuario2.setNombre("Manuel");
        usuario2.setApellido("Reyes");
        usuario2.setEmail("manu@gmail.com");
        usuario2.setTelefono("5451");

        Usuario usuario3 = new Usuario();
        usuario3.setId(20L);
        usuario3.setNombre("Esteban");
        usuario3.setApellido("Reyes");
        usuario3.setEmail("esteban@gmail.com");
        usuario3.setTelefono("515151");

        usuarios.add(usuario);
        usuarios.add(usuario2);
        usuarios.add(usuario3);

        return usuarios;




    }

}
