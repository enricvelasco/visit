package com.visitore.visitoreclient.loader;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.visitore.visitoreclient.PantallaPrincipal.PantallaPrincipalActivity;
import com.visitore.visitoreclient.R;
import com.visitore.visitoreclient.login.LoginInit;

public class LoadingIncialActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_incial);
        mAuth = FirebaseAuth.getInstance();
    }

    private void goToMenuPrincipal() {
        Intent i = new Intent(this, PantallaPrincipalActivity.class);
        startActivity(i);
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
        if (user != null) {
            // Name, email address, and profile photo Url
            String name = user.getDisplayName();
            String email = user.getEmail();
            Uri photoUrl = user.getPhotoUrl();

            // Check if user's email is verified
            boolean emailVerified = user.isEmailVerified();
            String uid = user.getUid();

            Log.d("CURRENT USER", user.getEmail());
            goToMenuPrincipal();
        }else{
            System.out.println("NO ESTÁ LOG IN");
            Intent i = new Intent(this, LoginInit.class);
            startActivity(i);
        }

    }
}
