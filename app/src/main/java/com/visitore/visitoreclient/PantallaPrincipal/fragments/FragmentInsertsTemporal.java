package com.visitore.visitoreclient.PantallaPrincipal.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.visitore.visitoreclient.R;
import com.visitore.visitoreclient.core.domain.CategoriasProductos;

import java.util.ArrayList;
import java.util.List;

public class FragmentInsertsTemporal extends Fragment {
    private List<CategoriasProductos> tcategoriasProductosList = new ArrayList<>();
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    public FragmentInsertsTemporal() {
    }

    public static Fragment newInstance() {
        FragmentInsertsTemporal fragment = new FragmentInsertsTemporal();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inserts, container, false);

        final Button borrarCategorias = view.findViewById(R.id.deleteAllCategorias);
        borrarCategorias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                borrarTodasCategorias();
            }
        });
        Button generarCategoria = view.findViewById(R.id.buttonAddCategorias);
        generarCategoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generarCategorias();
            }
        });

        return view;
    }

    private void borrarTodasCategorias() {
        db.collection("categoriasProductos")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (DocumentSnapshot document : task.getResult()) {
                                System.out.println("OK "+document.getData());
                                CategoriasProductos cate = document.toObject(CategoriasProductos.class);
                                System.out.println("OK-2 "+cate.getNombre());
                                db.collection("categoriasProductos").document(cate.get_id())
                                        .delete()
                                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void aVoid) {
                                                System.out.println("ELIMINADO OK");
                                            }
                                        })
                                        .addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                System.out.println("ERROR ELIMINAR");
                                            }
                                        });
                            }
                            System.out.println("TERMINA DELETE 2");
                        } else {
                            System.out.println("ERROR");
                        }
                        System.out.println("TERMINA READ");


                    }

                });
    }

    private void generarCategorias() {
        CategoriasProductos c1 = new CategoriasProductos("MODA");
        tcategoriasProductosList.add(c1);
        CategoriasProductos c2 = new CategoriasProductos("RESTAURACIÓN");
        tcategoriasProductosList.add(c2);
        CategoriasProductos c3 = new CategoriasProductos("MENAGE");
        tcategoriasProductosList.add(c3);
        CategoriasProductos c4 = new CategoriasProductos("SALUD Y BELLEZA");
        tcategoriasProductosList.add(c4);
        CategoriasProductos c5 = new CategoriasProductos("MOTOR");
        tcategoriasProductosList.add(c5);



        for(CategoriasProductos cat:tcategoriasProductosList){
            db.collection("categoriasProductos")
                    .document(cat.get_id())
                    .set(cat);
        }
        System.out.println("TERMINA DE INSERTAR");


    }
}
