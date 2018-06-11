package com.visitore.visitoreclient.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.visitore.visitoreclient.PantallaPrincipal.PantallaPrincipalActivity;
import com.visitore.visitoreclient.R;
import com.visitore.visitoreclient.menuPrincipal.MenuPrincipal;

public class LoginInit extends AppCompatActivity {
    private FloatingActionButton botonAcceso;
    private FirebaseAuth mAuth;
    private EditText email;
    private EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_init);

        email = findViewById(R.id.loginEmail);
        password = findViewById(R.id.loginPassword);

        botonAcceso = findViewById(R.id.botonAccess);
        botonAcceso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent i = new Intent(getApplicationContext(), PantallaPrincipalActivity.class);
                startActivity(i);*/
                realizarElLogIn(email.getText().toString(), password.getText().toString());
            }
        });
        mAuth = FirebaseAuth.getInstance();
        /*mAuth.signInWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            //Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            //updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            //Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(LoginInit.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }

                    }
                });*/
    }

    private void realizarElLogIn(String strEmail, String strPassword) {
        try{
            mAuth.signInWithEmailAndPassword(strEmail, strPassword)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                //Log.d(TAG, "signInWithEmail:success");
                                FirebaseUser user = mAuth.getCurrentUser();
                                //updateUI(user);
                                goToMenuPrincipal();
                            } else {
                                // If sign in fails, display a message to the user.
                                //Log.w(TAG, "signInWithEmail:failure", task.getException());
                                Toast.makeText(LoginInit.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                                //updateUI(null);
                            }

                        }
                    });
        }catch (Exception e){
            Toast.makeText(LoginInit.this, "Authentication failed.",
                    Toast.LENGTH_SHORT).show();
        }
    }

    private void goToMenuPrincipal() {
        Intent i = new Intent(this, PantallaPrincipalActivity.class);
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        //el boton back de la parte inferior esta desactivado
        //super.onBackPressed();
        System.out.println("HA APRETADO EL BACK");
    }

}
