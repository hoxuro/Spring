package com.myshoppingcart.persistence;

import com.myshoppingcart.model.Usuario;

import java.util.List;


public interface IUsuarioRepository {
    public boolean existeUsuario(String email, String password) throws Exception;

    public Usuario getUsuario(String email, String pass) throws Exception;

    public List<Usuario> getUsuarios(String iniciales) throws Exception;

    public Usuario insertUsuario(Usuario nuevoUsuario) throws Exception;

    public Usuario updateUsuario(Usuario actUsuario) throws Exception;

    public boolean deleteUsuario(Integer uid) throws Exception;
}
