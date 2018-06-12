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
import com.visitore.visitoreclient.core.domain.Asociacion;
import com.visitore.visitoreclient.core.domain.CategoriasProductos;
import com.visitore.visitoreclient.core.domain.Producto;
import com.visitore.visitoreclient.core.domain.Tienda;

import java.util.ArrayList;
import java.util.List;

public class FragmentInsertsTemporal extends Fragment {
    private List<CategoriasProductos> tcategoriasProductosList;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    List<Asociacion> listaAsociaciones;
    List<Tienda> listaTiendas;
    List<Producto> listaProductos;
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

        Button instertAll = view.findViewById(R.id.insertAll);
        instertAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertAsociaciones();
                insertTiendas();
                insertProductos();
            }
        });

        return view;
    }

    private void insertProductos() {
        listaProductos = new ArrayList<>();
        for(int i=0; i<10; i++){
            Producto p = new Producto();
            p.setNombre("Producto1Cat1_"+i);
            p.setIdAsociacion(listaAsociaciones.get(1).get_id());
            p.setIdCategoriaProducto(tcategoriasProductosList.get(0).get_id());
            p.setIdTienda(listaTiendas.get(1).get_id());
            listaProductos.add(p);
        }
        for(int i=0; i<10; i++){
            Producto p = new Producto();
            p.setNombre("ProductoCat2_"+i);
            p.setIdAsociacion(listaAsociaciones.get(1).get_id());
            p.setIdCategoriaProducto(tcategoriasProductosList.get(2).get_id());
            p.setIdTienda(listaTiendas.get(1).get_id());
            listaProductos.add(p);
        }

        for(int i=0; i<10; i++){
            Producto p = new Producto();
            p.setNombre("ProductoCat3_"+i);
            p.setIdAsociacion(listaAsociaciones.get(1).get_id());
            p.setIdCategoriaProducto(tcategoriasProductosList.get(3).get_id());
            p.setIdTienda(listaTiendas.get(1).get_id());
            listaProductos.add(p);
        }

        for(int i=0; i<20; i++){
            Producto p = new Producto();
            p.setNombre("Producto2_"+i);
            p.setIdAsociacion(listaAsociaciones.get(1).get_id());
            p.setIdCategoriaProducto(tcategoriasProductosList.get(2).get_id());
            p.setIdTienda(listaTiendas.get(2).get_id());
            listaProductos.add(p);
        }

        for (Producto producto:listaProductos){
            db.collection("productos")
                    .document(producto.get_id())
                    .set(producto);
        }

    }

    private void insertTiendas() {
        listaTiendas = new ArrayList<>();
        Tienda t1 = new Tienda();
        t1.setNombre("MANGO");
        t1.setIdAsociacion(listaAsociaciones.get(0).get_id());

        Tienda t2 = new Tienda();
        t2.setNombre("LEVI'S");
        t2.setIdAsociacion(listaAsociaciones.get(0).get_id());

        Tienda t3 = new Tienda();
        t3.setNombre("Massimo Dutti");
        t3.setIdAsociacion(listaAsociaciones.get(0).get_id());

        Tienda t4 = new Tienda();
        t4.setNombre("ZARA");
        t4.setIdAsociacion(listaAsociaciones.get(0).get_id());

        Tienda t5 = new Tienda();
        t5.setNombre("PIZZERIA");
        t5.setIdAsociacion(listaAsociaciones.get(1).get_id());

        Tienda t6 = new Tienda();
        t6.setNombre("HAMBURGUESERIA");
        t6.setIdAsociacion(listaAsociaciones.get(1).get_id());

        listaTiendas.add(t1);
        listaTiendas.add(t2);
        listaTiendas.add(t3);
        listaTiendas.add(t4);
        listaTiendas.add(t5);
        listaTiendas.add(t6);

        for(Tienda tienda:listaTiendas){
            db.collection("tiendas")
                    .document(tienda.get_id())
                    .set(tienda);
        }
    }

    private void insertAsociaciones() {
        listaAsociaciones = new ArrayList<>();
        Asociacion a1 = new Asociacion();
        a1.setNombre("Asociació Gracia");
        Asociacion a2 = new Asociacion();
        a2.setNombre("Asociació Sants");
        listaAsociaciones.add(a1);
        listaAsociaciones.add(a2);

        for(Asociacion asociacion:listaAsociaciones){
            db.collection("asociaciones")
                    .document(asociacion.get_id())
                    .set(asociacion);
        }
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
        tcategoriasProductosList = new ArrayList<>();

        CategoriasProductos c1 = new CategoriasProductos("MODA");
        //tcategoriasProductosList.add(c1);
        List<CategoriasProductos> listaSubcategoria = new ArrayList<>();
        CategoriasProductos s1 = new CategoriasProductos("Moda Hombre");
            List<CategoriasProductos> sub1List = new ArrayList<>();
            CategoriasProductos as1 = new CategoriasProductos();
            as1.setNombre("Camisas");
            CategoriasProductos as2 = new CategoriasProductos();
            as2.setNombre("Ropa deporte");
            s1.setCategoriasHijas(sub1List);
            listaSubcategoria.add(s1);
        CategoriasProductos s2 = new CategoriasProductos("Moda Mujer");
        listaSubcategoria.add(s2);
        c1.setCategoriasHijas(listaSubcategoria);
        tcategoriasProductosList.add(c1);

        CategoriasProductos c2 = new CategoriasProductos("RESTAURACIÓN");
        //tcategoriasProductosList.add(c2);
        List<CategoriasProductos> listaSubcategoria2 = new ArrayList<>();
        CategoriasProductos ss1 = new CategoriasProductos("Hamburgueseria");
        listaSubcategoria2.add(ss1);
        CategoriasProductos ss2 = new CategoriasProductos("Pizzeria");
        listaSubcategoria2.add(ss2);
        c2.setCategoriasHijas(listaSubcategoria2);
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
