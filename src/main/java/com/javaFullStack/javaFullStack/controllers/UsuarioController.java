package com.javaFullStack.javaFullStack.controllers;

import com.javaFullStack.javaFullStack.dao.UsuarioDao;
import com.javaFullStack.javaFullStack.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioDao usuarioDao;

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

    @RequestMapping(value = "api/usuarios")
    public List<Usuario> getUsuario(){
        return usuarioDao.getUsuarios();
    }

    @RequestMapping(value = "api/usuarios", method = RequestMethod.POST)
    public void registrarUsuarios(@RequestBody Usuario usuario){
        usuarioDao.registrar(usuario);
    }


    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.DELETE)
    public void eliminar (@PathVariable Long id){
        usuarioDao.eliminar(id);
    }




}
