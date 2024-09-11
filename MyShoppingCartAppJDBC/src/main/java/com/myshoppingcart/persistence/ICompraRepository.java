package com.myshoppingcart.persistence;

import com.myshoppingcart.model.Compra;

public interface ICompraRepository {

    Compra insertCompra(Compra nuevaCompra) throws Exception;

}
