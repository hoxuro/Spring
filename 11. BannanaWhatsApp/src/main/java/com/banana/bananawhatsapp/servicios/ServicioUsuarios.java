package com.banana.bananawhatsapp.servicios;

import com.banana.bananawhatsapp.exceptions.UsuarioException;
import com.banana.bananawhatsapp.modelos.Usuario;
import com.banana.bananawhatsapp.persistencia.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Set;

@Service
public class ServicioUsuarios implements IServicioUsuarios {

    @Autowired
    IUsuarioRepository usuarioRepo;

    @Override
    public Usuario obtener(int id) throws UsuarioException {
        // Obtaining the user thnks to the ID
        try {
            Usuario usuario = usuarioRepo.obtener(id);
            return usuario;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) throws UsuarioException {
        // Create a new user
        try {
            Usuario nuevoUsuario = usuarioRepo.crear(usuario);
            return nuevoUsuario;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean borrarUsuario(Usuario usuario) throws UsuarioException {
        try {
            Usuario borrarUsuario = usuarioRepo.obtener(usuario.getId());
            usuarioRepo.borrar(borrarUsuario);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public Usuario actualizarUsuario(Usuario usuario) throws UsuarioException {
        try {
            Usuario actUsuario = usuarioRepo.obtener(usuario.getId());
            usuarioRepo.actualizar(actUsuario);
            return actUsuario;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public Set<Usuario> obtenerPosiblesDesinatarios(Usuario usuario, int max) throws UsuarioException {
        return Set.of();
    }
}
