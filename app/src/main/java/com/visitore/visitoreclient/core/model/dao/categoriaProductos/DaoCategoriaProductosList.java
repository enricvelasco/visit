package com.visitore.visitoreclient.core.model.dao.categoriaProductos;

import com.visitore.visitoreclient.core.domain.CategoriaProductos;

import java.util.List;

public interface DaoCategoriaProductosList extends DaoCategoriaProductos{
    void onSuccessList(List<CategoriaProductos> categoriaProductosList);

    @Override
    void onFailed(String e);
}
