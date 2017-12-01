package com.example.akuma.preferenciasdatos;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.view.View;
import android.content.Intent;


public class MainActivity extends AppCompatActivity {

    private Button guardar;
    private TextView nombre, apellidos, dni, sexo;
    private EditText EditNombre, EditApellidos, EditDni;
    private RadioButton rbHombre, rbMujer;
    public static final String pref = "Mis preferencias";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //DATOS
        EditNombre = (EditText) findViewById(R.id.editNombre);
        EditApellidos = (EditText) findViewById(R.id.editApellidos);
        EditDni = (EditText) findViewById(R.id.editDni);
        rbHombre = (RadioButton) findViewById(R.id.rbHombre);
        rbMujer = (RadioButton) findViewById(R.id.rbMujer);
        guardar = (Button) findViewById(R.id.buttonGuardar);

        final MainActivity mainActivity = this;

        guardar.setOnClickListener(new View.OnClickListener(){

            public String datoSexo(){
                if (rbHombre.isChecked()){
                    String sexo = "Hombre";
                    return sexo;
                }else{
                    String sexo = "Mujer";
                    return sexo;
                }
            }

            @Override
            public void onClick(View view){
                Intent intento = new Intent(mainActivity, ActivityPerfil.class);

                //Creamos el objeto preferencias
                SharedPreferences preferencias = getSharedPreferences(pref, MainActivity.MODE_PRIVATE);
                //Creamos un editor para los datos de las preferencias
                SharedPreferences.Editor editor = preferencias.edit();

                editor.putString("nombre",EditNombre.getText().toString());
                editor.putString("apellidos",EditApellidos.getText().toString());
                editor.putString("dni",EditDni.getText().toString());
                editor.putString("datoSexo",datoSexo().toString());//El valor de DatoSexo dependerá del resultado del checkeo en la función datoSexo()

                editor.commit();
                startActivity(intento);


            }
        });
    }
}
