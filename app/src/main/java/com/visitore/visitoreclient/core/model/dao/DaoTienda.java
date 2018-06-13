package com.visitore.visitoreclient.core.model.dao;

import com.visitore.visitoreclient.core.domain.Tienda;

import java.util.List;

public interface DaoTienda {
    void onSuccessList(List<Tienda> tiendaList);
    void onSuccessRead(Tienda tienda);
    void onSuccessDeleted();
    void onFailed(String e);
}
