package com.visitore.visitoreclient.core.model;

import android.support.annotation.NonNull;
import android.util.Log;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.visitore.visitoreclient.core.domain.CategoriaProductos;
import com.visitore.visitoreclient.core.model.dao.categoriaProductos.DaoCategoriaProductos;
import com.visitore.visitoreclient.core.model.dao.categoriaProductos.DaoCategoriaProductosDelete;
import com.visitore.visitoreclient.core.model.dao.categoriaProductos.DaoCategoriaProductosList;
import com.visitore.visitoreclient.core.model.dao.categoriaProductos.DaoCategoriaProductosRead;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoriaProductosModel {
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference collection = db.collection("categoriasProductos");
    private String TAG = "[categoriasProductos]";

    public void listado(final DaoCategoriaProductosList listener){
        collection.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    List<CategoriaProductos> categoriaListResp = new ArrayList<>();
                    for (DocumentSnapshot document : task.getResult()) {
                        CategoriaProductos cate = document.toObject(CategoriaProductos.class);
                        categoriaListResp.add(cate);
                    }
                    listener.onSuccessList(categoriaListResp);
                } else {
                    System.out.println("ERROR");
                    Log.d(TAG,"error al devolvel categorias");
                    listener.onFailed("Error TASK NOT successfull");
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d(TAG,"error al devolvel categorias");
                listener.onFailed(e.getMessage());
            }
        });
    }

    public void read(String id, final DaoCategoriaProductosRead listener){
        DocumentReference docRef = collection.document(id);
        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                listener.onSuccessRead(documentSnapshot.toObject(CategoriaProductos.class));
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });
    }

    public String insert(CategoriaProductos categoriaProductos){
        try{
            collection.document(categoriaProductos.get_id()).set(categoriaProductos);
            return "200";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    public Map<String,List<CategoriaProductos>> insertMassive(List<CategoriaProductos> categoriaProductosList){
        //final DocumentReference sfDocRef = collection;
        Map<String,List<CategoriaProductos>> respuesta = new HashMap<>();
        List<CategoriaProductos>listOK = new ArrayList<>();
        List<CategoriaProductos>listBAD = new ArrayList<>();
        for(CategoriaProductos cat:categoriaProductosList){
            String ret = insert(cat);
            if(ret.equals("200")){
                listOK.add(cat);
            }else{
                listBAD.add(cat);
            }
        }
        respuesta.put("ok", listOK);
        respuesta.put("bad", listBAD);
        return respuesta;
    }

    public String update(CategoriaProductos categoriaProductos){
        try {
            /*Map<String, Object> objectAsMap = BeanUtils.describe(categoriaProductos);*/
            ObjectMapper oMapper = new ObjectMapper();
            Map<String, Object> map = oMapper.convertValue(categoriaProductos, Map.class);
            collection.document(categoriaProductos.get_id()).update(map);
            return "200";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    public Map<String,List<CategoriaProductos>> updateMassive(List<CategoriaProductos> categoriaProductosList){
        Map<String,List<CategoriaProductos>> respuesta = new HashMap<>();
        List<CategoriaProductos>listOK = new ArrayList<>();
        List<CategoriaProductos>listBAD = new ArrayList<>();
        for(CategoriaProductos cat:categoriaProductosList){
            String ret = update(cat);
            if(ret.equals("200")){
                listOK.add(cat);
            }else{
                listBAD.add(cat);
            }
        }
        respuesta.put("ok", listOK);
        respuesta.put("bad", listBAD);
        return respuesta;
    }

    public void delete(String id, final DaoCategoriaProductosDelete listener){
        collection.document(id).delete().addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                listener.onSuccessDeleted();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                listener.onFailed(e.getMessage());
            }
        });
    }

}
