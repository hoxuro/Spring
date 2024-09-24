package com.myshoppingcart.persistence;

import com.myshoppingcart.model.Producto;

import java.util.List;

public interface IProductoRepository {

    Producto getProduct(int pid) throws Exception;

    List<Producto> getProducts() throws Exception;

    List<Producto> getUserProducts(int uid) throws Exception;

    Producto insertarProducto(Producto prod) throws Exception;

    Producto actualizarProducto(Producto prod) throws Exception;

    boolean borrarProducto(Producto prod) throws Exception;
}
