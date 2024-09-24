package com.myshoppingcart.persistence;

import com.myshoppingcart.exception.UsuarioNotFoundException;
import com.myshoppingcart.model.Usuario;
import lombok.Setter;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Setter
@Repository
public class UsuarioJPARepository implements IUsuarioRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public boolean existeUsuario(String email, String pass) throws Exception {
        Usuario usuario = this.getUsuario(email, pass);
        return usuario != null;
    }

    @Override
    public Usuario getUsuario(String email, String pass) throws UsuarioNotFoundException, Exception {
        try {
            TypedQuery query = em.createQuery("SELECT u FROM Usuario u WHERE u.email = :email AND u.password = :pass", Usuario.class);
            query.setParameter("email", email);
            query.setParameter("pass", pass);

            return (Usuario) query.getSingleResult();
        } catch (NoResultException e) {
            throw new UsuarioNotFoundException();
        }
    }

    @Override
    public List<Usuario> getUsuarios(String iniciales) throws Exception {
        TypedQuery query = em.createQuery("SELECT u FROM Usuario u WHERE u.nombre LIKE :inicial", Usuario.class);
        query.setParameter("inicial", iniciales);

        List<Usuario> users = (List<Usuario>) query.getResultList();

        return users;
    }

    @Override
    @Transactional
    public Usuario insertUsuario(Usuario nuevoUsuario) throws Exception {
        em.persist(nuevoUsuario);
        return nuevoUsuario;
    }

    @Override
    @Transactional
    public Usuario updateUsuario(Usuario actUsuario) throws Exception {
        em.merge(actUsuario);
        System.out.println(em.merge(actUsuario));
        return actUsuario;
    }

    @Override
    @Transactional
    public boolean deleteUsuario(Integer uid) throws Exception {
        Usuario userToDelete = new Usuario(uid);
        em.remove(em.contains(userToDelete) ? userToDelete : em.merge(userToDelete));
        return true;
    }
}
