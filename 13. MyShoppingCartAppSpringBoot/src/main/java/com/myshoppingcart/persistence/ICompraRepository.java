package com.myshoppingcart.persistence;

import com.myshoppingcart.model.Compra;
import com.myshoppingcart.model.Producto;
import com.myshoppingcart.model.Usuario;

public interface ICompraRepository {

    Compra insertCompra(Compra nuevaCompra) throws Exception;

    Producto findProduct(Integer pid) throws Exception;

    Usuario findUsuario(Integer uid) throws Exception;
}
