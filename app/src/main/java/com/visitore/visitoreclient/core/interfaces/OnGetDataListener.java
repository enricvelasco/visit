package com.visitore.visitoreclient.core.interfaces;

import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.QuerySnapshot;
import com.visitore.visitoreclient.core.domain.Asociacion;

import java.util.List;

public interface OnGetDataListener {
    public void onStart();
    public void onSuccess(List<Asociacion> asociacion);
    public void onFailed(Exception e);
}
