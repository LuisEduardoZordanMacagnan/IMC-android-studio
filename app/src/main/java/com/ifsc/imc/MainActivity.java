package com.ifsc.imc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText textoPeso;
    EditText textoAltura;
    EditText textoNome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textoPeso = findViewById(R.id.editTextPeso);
        textoAltura = findViewById(R.id.editTextAltura);
        textoNome = findViewById(R.id.editTextNome);
    }

    @Override
    protected void onStart() {
        super.onStart();
        textoPeso = findViewById(R.id.editTextPeso);
        textoAltura = findViewById(R.id.editTextAltura);
        textoNome = findViewById(R.id.editTextNome);
    }

    public void Calcular(View v){
        String nome;
        Float peso, altura;
        nome=String.valueOf(textoNome.getText());
        peso=Float.valueOf(String.valueOf(textoPeso));
        altura=Float.valueOf(String.valueOf(textoAltura));
        Intent i = new Intent(this, ImcActivity.class);
        i.putExtra("nome", nome);
        i.putExtra("peso", peso);
        i.putExtra("altura", altura);
        startActivity(i);
    }
}