package com.visitore.visitoreclient.core.model.dao;

import com.visitore.visitoreclient.core.domain.Producto;

import java.util.List;

public interface DaoProducto {
    boolean onSuccessList(List<Producto> productosList);
    void onSuccessRead(Producto producto);
    void onSuccessDeleted();
    void onFailed(String e);
}
