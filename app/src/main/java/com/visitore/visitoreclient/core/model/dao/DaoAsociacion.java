package com.visitore.visitoreclient.core.model.dao;

import com.visitore.visitoreclient.core.domain.Asociacion;
import java.util.List;

public interface DaoAsociacion {
    void onSuccessList(List<Asociacion> asociacionList);
    void onSuccessRead(Asociacion asociacion);
    void onSuccessDeleted();
    void onFailed(String e);
}
