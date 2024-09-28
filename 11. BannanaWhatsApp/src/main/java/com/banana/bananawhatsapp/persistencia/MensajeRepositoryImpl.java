package com.banana.bananawhatsapp.persistencia;

import com.banana.bananawhatsapp.exceptions.MensajeException;
import com.banana.bananawhatsapp.modelos.Mensaje;
import com.banana.bananawhatsapp.modelos.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.TransactionScoped;
import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;


@Repository
public class MensajeRepositoryImpl implements IMensajeRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public Mensaje crear(Mensaje mensaje) throws MensajeException, SQLException {
        if(mensaje.getCuerpo().length() < 10){
            throw new MensajeException("El cuerpo debe ser mayor que 10");
        }
        em.persist(mensaje);
        return mensaje;
    }

    @Override
    public List<Mensaje> obtener(Usuario usuario) throws SQLException {
        return List.of();
    }

    @Override
    public boolean borrarEntre(Usuario remitente, Usuario destinatario) throws Exception {
        return false;
    }

    @Override
    public boolean borrarTodos(Usuario usuario) throws SQLException {
        return false;
    }

}
