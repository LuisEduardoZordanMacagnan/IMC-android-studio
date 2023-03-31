package com.ifsc.imc;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ImcActivity extends AppCompatActivity {
    String nome, result;
    Integer img;
    Float peso, altura, imc;
    TextView textoNome, textoPeso, textoAltura, textoResultado, textoImc;
    ImageView imagem;
    int[] imagens = {
            R.drawable.abaixopeso,
            R.drawable.normal,
            R.drawable.sobrepeso,
            R.drawable.obesidade1,
            R.drawable.obesidade2,
            R.drawable.obesidade3
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        Bundle bundle = getIntent().getExtras();
        nome = bundle.getString("nome");
        peso = bundle.getFloat("peso");
        altura = bundle.getFloat("altura");
        textoNome = findViewById(R.id.textViewNome);
        textoPeso = findViewById(R.id.textViewPeso);
        textoAltura = findViewById(R.id.textViewAltura);
        textoResultado = findViewById(R.id.textViewResultado);
        textoImc = findViewById(R.id.textViewImc);
        imagem = findViewById(R.id.imageView);
    }

    @Override
    protected void onStart() {
        super.onStart();
        imc = calcImc(peso, altura);
        if(imc<18.5){
            result="Abaixo do peso";
            img=0;
        }else if(imc<24.9){
            result="Peso normal";
            img=1;
        }else if(imc<29.9){
            result="Sobrepeso";
            img=2;
        }else if(imc<34.9){
            result="Obesidade grau 1";
            img=3;
        }else if(imc<39.9){
            result="Obesidade grau 2";
            img=4;
        }else {
            result="Obesidade grau 3";
            img=5;
        }
        textoImc.setText(String.valueOf(imc));
        textoNome.setText(nome);
        textoPeso.setText(String.valueOf(peso));
        textoAltura.setText(String.valueOf(altura));
        textoResultado.setText(result);
        imagem.setImageResource(imagens[img]);
    }

    public Float calcImc(Float peso, Float altura){
        Float imc=peso/(altura*altura);
        return imc;
    }

    public void voltar(View v){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}