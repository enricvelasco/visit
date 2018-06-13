package com.visitore.visitoreclient.core.model.dao.categoriaProductos;

import com.visitore.visitoreclient.core.domain.CategoriaProductos;

import java.util.List;

public interface DaoCategoriaProductos {
    /*void onSuccessList(List<CategoriaProductos> categoriaProductosList);
    void onSuccessRead(CategoriaProductos categoriaProductos);
    void onSuccessDeleted();*/
    void onFailed(String e);
}
