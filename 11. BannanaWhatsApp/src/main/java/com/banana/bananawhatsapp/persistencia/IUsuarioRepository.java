package com.banana.bananawhatsapp.persistencia;

import com.banana.bananawhatsapp.exceptions.UsuarioException;
import com.banana.bananawhatsapp.modelos.Usuario;

import java.sql.SQLException;
import java.util.Set;

public interface IUsuarioRepository {
    public Usuario obtener(int id) throws SQLException;
    public Usuario crear(Usuario usuario) throws Exception, SQLException;

    public Usuario actualizar(Usuario usuario) throws UsuarioException, SQLException;

    public boolean borrar(Usuario usuario) throws UsuarioException, SQLException;

    public Set<Usuario> obtenerPosiblesDestinatarios(Integer id, Integer max) throws SQLException;

}
