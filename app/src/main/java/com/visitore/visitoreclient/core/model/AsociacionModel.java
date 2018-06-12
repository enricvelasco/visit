package com.visitore.visitoreclient.core.model;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.visitore.visitoreclient.core.domain.Asociacion;
import com.visitore.visitoreclient.core.interfaces.OnGetDataListener;
import com.visitore.visitoreclient.core.model.dao.DaoAsociacion;

import java.util.ArrayList;
import java.util.List;

public class AsociacionModel{
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference collection = db.collection("asociaciones");
    private String TAG = "[asociaciones]";

    public AsociacionModel() {
    }

    public void listado(final DaoAsociacion listener){
        collection.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {

            }
        });
    }

}
