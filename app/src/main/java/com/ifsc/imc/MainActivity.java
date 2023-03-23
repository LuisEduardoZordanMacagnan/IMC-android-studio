package com.ifsc.imc;

import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Float peso;
    private Float altura;
    private EditText txtPeso;
    private EditText txtAltura;
    private TextView textImc;
    private TextView textDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtPeso = (EditText) findViewById(R.id.editTxtPeso);
        txtAltura = (EditText) findViewById(R.id.editTxtAltura);
        textImc = (TextView) findViewById(R.id.txtImc);
        textDesc = (TextView) findViewById(R.id.txtDesc);
    }

    public void Calcular(View view){
        peso = Float.valueOf(String.valueOf(txtPeso.getText()));
        altura = Float.valueOf(String.valueOf(txtAltura.getText()));
        Float imc = (peso/(altura*altura));
        textImc.setText(String.valueOf(imc));
        textDesc.setText(SetDesc(imc));
    }

    private String SetDesc(Float imc){
        String desc;
        if(imc<18.5){
            desc="Abaixo do peso";
        }else if(imc<24.9){
            desc="Peso normal";
        }else if(imc<29.9){
            desc="Sobrepeso";
        }else if(imc<34.9){
            desc="Obesidade grau 1";
        }else if(imc<39.9){
            desc="Obesidade grau 2";
        }else if(imc<34.9){
            desc="Obesidade grau 1";
        }else{
            desc="Obesidade grau 1";
        }
        return desc;
    }
}