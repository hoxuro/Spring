package com.banana.bananawhatsapp.persistencia;

import com.banana.bananawhatsapp.exceptions.UsuarioException;
import com.banana.bananawhatsapp.modelos.Usuario;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.Set;

@Repository
public class UsuarioRepositoryImpl implements IUsuarioRepository {

    @PersistenceContext
    private EntityManager em;


    @Override
    public Usuario obtener(int id) throws SQLException {
        return em.find(Usuario.class, id);
    }

    @Override
    @Transactional
    public Usuario crear(Usuario usuario) throws Exception, SQLException {
        if (usuario.getNombre() == null || usuario.getNombre().isEmpty()) {
            throw new Exception();
        }

        if (usuario.getEmail() == null || !usuario.getEmail().contains("@")) {
            throw new Exception("El correo electrónico no es válido");
        }

        em.persist(usuario);
        return usuario;
    }

    @Override
    @Transactional
    public Usuario actualizar(Usuario usuario) throws UsuarioException, SQLException {
        Usuario existeEnDB = em.find(Usuario.class, usuario.getId());

        if (existeEnDB == null) {
            throw new UsuarioException("El usuario con ID " + usuario.getId() + " no existe");
        }

        em.merge(usuario);
        return usuario;
    }

    @Override
    @Transactional
    public boolean borrar(Usuario usuario) throws UsuarioException, SQLException {
        if (em.find(Usuario.class, usuario.getId()) == null) {
            throw new UsuarioException("El usuario no existe.");
        }
        em.remove(em.contains(usuario) ? usuario : em.merge(usuario));
        return true;
    }

    @Override
    public Set<Usuario> obtenerPosiblesDestinatarios(Integer id, Integer max) throws SQLException {
        return Set.of();
    }
}
