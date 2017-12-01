package com.example.akuma.preferenciasdatos;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class ActivityPerfil extends AppCompatActivity{

    public static final String pref = "Mis preferencias";

    private TextView RecibirNombre, RecibirApellidos, RecibirDni, RecibirSexo;

    @Override
    protected void onCreate(Bundle savedInstanceState){

        Intent intento = getIntent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        RecibirNombre = (TextView) findViewById(R.id.Recibir_nombre);//VARIABLES PARA CONTENER LOS DATOS
        RecibirApellidos = (TextView) findViewById(R.id.Recibir_apellidos);
        RecibirDni = (TextView) findViewById(R.id.Recibir_dni);
        RecibirSexo = (TextView) findViewById(R.id.Recibir_sexo);

        SharedPreferences preferencias = getSharedPreferences(pref, Activity.MODE_PRIVATE);

        String datoNombre = preferencias.getString("nombre", RecibirNombre.getText().toString());
        String datoApellidos = preferencias.getString("apellidos", RecibirApellidos.getText().toString());
        String datoDni = preferencias.getString("dni", RecibirDni.getText().toString());
        String datoSexo = preferencias.getString("sexo", RecibirSexo.getText().toString());

            RecibirNombre.setText(datoNombre);//PONE EL TEXTO EN LOS STRING
            RecibirApellidos.setText(datoApellidos);
            RecibirDni.setText(datoDni);
            RecibirSexo.setText(datoSexo);
        }
    }


