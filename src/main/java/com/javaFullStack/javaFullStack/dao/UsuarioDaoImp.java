package com.javaFullStack.javaFullStack.dao;
import org.springframework.transaction.annotation.Transactional;



import com.javaFullStack.javaFullStack.models.Usuario;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional

public class UsuarioDaoImp implements UsuarioDao {

    @Override
    public List<Usuario> getUsuarios() {
        return List.of();
    }
}
