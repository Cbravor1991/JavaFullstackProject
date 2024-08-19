package com.javaFullStack.javaFullStack.controllers;

import com.javaFullStack.javaFullStack.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.javaFullStack.javaFullStack.dao.UsuarioDao;

@RestController
public class AuthController {

    @Autowired
    private UsuarioDao usuarioDao;

    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String login(@RequestBody Usuario usuario){
        if(usuarioDao.verificarCredenciales(usuario)) {
            return "CREDENCIALES CORRECTAS";
        }
        return "CREDENCIALES INCORRECTAS";
    }

}
