package com.visitore.visitoreclient.core.model.dao.categoriaProductos;

import com.visitore.visitoreclient.core.domain.CategoriaProductos;

public interface DaoCategoriaProductosRead extends DaoCategoriaProductos{
    void onSuccessRead(CategoriaProductos categoriaProductos);

    @Override
    void onFailed(String e);
}
