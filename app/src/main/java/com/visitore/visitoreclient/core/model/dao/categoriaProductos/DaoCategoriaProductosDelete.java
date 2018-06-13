package com.visitore.visitoreclient.core.model.dao.categoriaProductos;

public interface DaoCategoriaProductosDelete extends DaoCategoriaProductos{
    void onSuccessDeleted();

    @Override
    void onFailed(String e);
}
