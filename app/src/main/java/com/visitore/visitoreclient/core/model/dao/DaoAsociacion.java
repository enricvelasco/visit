package com.visitore.visitoreclient.core.model.dao;

import com.visitore.visitoreclient.core.domain.Asociacion;
import java.util.List;

public interface DaoAsociacion {
    public void onStart();
    public void onSuccess(List<Asociacion> asociacion);
    public void onFailed(Exception e);
}
