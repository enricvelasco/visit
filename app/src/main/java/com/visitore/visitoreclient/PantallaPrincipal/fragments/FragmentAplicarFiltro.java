package com.visitore.visitoreclient.PantallaPrincipal.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.visitore.visitoreclient.R;

public class FragmentAplicarFiltro extends Fragment {
    public static FragmentAplicarFiltro newInstance() {
        FragmentAplicarFiltro fragment = new FragmentAplicarFiltro();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_1, container, false);
    }
}
