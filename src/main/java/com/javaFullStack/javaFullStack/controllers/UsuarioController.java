package com.javaFullStack.javaFullStack.controllers;

import com.javaFullStack.javaFullStack.dao.UsuarioDao;
import com.javaFullStack.javaFullStack.models.Usuario;
import com.javaFullStack.javaFullStack.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;

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

    @RequestMapping(value = "api/usuarios", method = RequestMethod.GET)
    public List<Usuario> getUsuario(@RequestHeader(value = "Authorization") String token) {
        if(!validarToken(token)){return  null; }
        return usuarioDao.getUsuarios();
    }

    private boolean validarToken(String token){
        String usuarioId = jwtUtil.getKey(token);
        return usuarioId!= null;
    }
    @RequestMapping(value = "api/usuarios", method = RequestMethod.POST)
    public void registrarUsuarios(@RequestBody Usuario usuario){

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        // Convertir la contraseña a char[]
        char[] passwordChars = usuario.getPassword().toCharArray();
        String hash = argon2.hash(1, 1024, 1, passwordChars);
        argon2.wipeArray(passwordChars);
        usuario.setPassword(hash);
        usuarioDao.registrar(usuario);
    }


    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.DELETE)
    public void eliminar (@RequestHeader(value = "Authorization") String token, @PathVariable Long id){
        if(!validarToken(token)){return; }
        usuarioDao.eliminar(id);
    }




}
