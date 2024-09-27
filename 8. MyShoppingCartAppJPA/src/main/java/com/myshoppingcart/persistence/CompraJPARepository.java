package com.myshoppingcart.persistence;

import com.myshoppingcart.model.Compra;
import com.myshoppingcart.model.Producto;
import com.myshoppingcart.model.Usuario;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.*;

@Setter
@Repository
public class CompraJPARepository implements ICompraRepository {

    @PersistenceContext
    private EntityManager em;


    @Override
    @Transactional
    public Compra insertCompra(Compra nuevaCompra) throws Exception {

        // INSERTAR NUEVA COMPRA
        em.persist(nuevaCompra);

        System.out.println("Nueva compra: " + nuevaCompra);

        return nuevaCompra;
    }

    @Override
    public Producto findProduct(Integer productId) throws Exception {
        return em.find(Producto.class, productId);
    }

    @Override
    public Usuario findUsuario(Integer uid) throws Exception {
        return em.find(Usuario.class, uid);
    }
}
