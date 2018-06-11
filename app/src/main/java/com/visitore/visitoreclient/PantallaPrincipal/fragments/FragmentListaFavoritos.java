package com.visitore.visitoreclient.PantallaPrincipal.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.visitore.visitoreclient.R;

public class FragmentListaFavoritos extends Fragment {
    public static FragmentListaFavoritos newInstance() {
        FragmentListaFavoritos fragment = new FragmentListaFavoritos();
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
