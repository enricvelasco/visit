package com.visitore.visitoreclient.PantallaPrincipal;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.visitore.visitoreclient.PantallaPrincipal.fragments.Fragment1;
import com.visitore.visitoreclient.PantallaPrincipal.fragments.Fragment2;
import com.visitore.visitoreclient.PantallaPrincipal.fragments.Fragment3;
import com.visitore.visitoreclient.PantallaPrincipal.fragments.FragmentDescubrir;
import com.visitore.visitoreclient.PantallaPrincipal.fragments.FragmentInsertsTemporal;
import com.visitore.visitoreclient.R;
import com.visitore.visitoreclient.core.BottomNavigationViewHelper;

public class PantallaPrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_principal);
        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

        cargaFragmentInicial();

        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.navigationView);

        BottomNavigationViewHelper.removeShiftMode(bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;
                switch (item.getItemId()) {
                    case R.id.item_1:
                        selectedFragment = FragmentDescubrir.newInstance();
                        Log.d("ITEM-1", "mostrar 1");
                        break;
                    case R.id.item_2:
                        selectedFragment = Fragment2.newInstance();
                        Log.d("ITEM-2", "mostrar 2");
                        break;
                    case R.id.item_3:
                        selectedFragment = Fragment3.newInstance();
                        Log.d("ITEM-3", "mostrar 3");
                        break;
                    case R.id.item_4:
                        selectedFragment = FragmentInsertsTemporal.newInstance();
                        Log.d("ITEM-4", "mostrar Perfil");
                        break;
                }
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_layout, selectedFragment);
                transaction.commit();
                return true;
            }
        });
    }

    private void cargaFragmentInicial() {
        Fragment selectedFragment = null;
        selectedFragment = FragmentDescubrir.newInstance();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, selectedFragment);
        transaction.commit();
    }

}
