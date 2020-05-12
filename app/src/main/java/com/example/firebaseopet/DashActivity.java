package com.example.firebaseopet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class DashActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private TextView textWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash);

        mAuth = FirebaseAuth.getInstance();
        textWelcome = findViewById(R.id.textWelcome);
    }

    @Override
    protected void onStart(){
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
        textWelcome.setText("Bem-vindo, "+user.getEmail());
    }

    public void sair(View view){
        mAuth.signOut();
        Intent inicio = new Intent(DashActivity.this,MainActivity.class);
        startActivity(inicio);
        finish();
    }

    public void registrardadosusuario(View view) {
        Intent cadoneactivity = new Intent(DashActivity.this,CadOneActivity.class);
        startActivity(cadoneactivity);
    }

    public void registrardadosvenda(View view) {
        Intent cad2activity = new Intent(DashActivity.this, CadTwoActivity.class);
        startActivity(cad2activity);
    }

    public void registrardadostarefa(View view) {
        Intent cadtarefaactivity = new Intent(DashActivity.this,CadTarefaActivity.class);
        startActivity(cadtarefaactivity);
    }
}
