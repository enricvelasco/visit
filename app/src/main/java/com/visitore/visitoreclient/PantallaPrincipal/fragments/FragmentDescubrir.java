package com.visitore.visitoreclient.PantallaPrincipal.fragments;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.visitore.visitoreclient.R;
import com.visitore.visitoreclient.core.domain.CategoriaProductos;
import com.visitore.visitoreclient.core.model.CategoriaProductosModel;
import com.visitore.visitoreclient.core.model.dao.categoriaProductos.DaoCategoriaProductos;
import com.visitore.visitoreclient.core.model.dao.categoriaProductos.DaoCategoriaProductosList;

import java.util.ArrayList;
import java.util.List;

public class FragmentDescubrir extends Fragment {


    public static FragmentDescubrir newInstance() {
        FragmentDescubrir fragment = new FragmentDescubrir();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_descubrir, container, false);


        //tabLayout.setTabMode(1);//0 = scrollable , 1 = fixed


        return view;
    }


}
