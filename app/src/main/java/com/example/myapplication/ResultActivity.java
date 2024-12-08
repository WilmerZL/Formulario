package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // Obtener referencias a los TextView
        TextView tvCedula = findViewById(R.id.tvCedula);
        TextView tvNombres = findViewById(R.id.tvNombres);
        TextView tvFechaNacimiento = findViewById(R.id.tvFechaNacimiento);
        TextView tvCiudad = findViewById(R.id.tvCiudad);
        TextView tvGenero = findViewById(R.id.tvGenero);
        TextView tvCorreo = findViewById(R.id.tvCorreo);
        TextView tvTelefono = findViewById(R.id.tvTelefono);

        // Obtener datos del Intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            tvCedula.setText("Cédula: " + extras.getString("cedula"));
            tvNombres.setText("Nombres: " + extras.getString("nombres"));
            tvFechaNacimiento.setText("Fecha de Nacimiento: " + extras.getString("fechaNacimiento"));
            tvCiudad.setText("Ciudad: " + extras.getString("ciudad"));
            tvGenero.setText("Género: " + extras.getString("genero"));
            tvCorreo.setText("Correo: " + extras.getString("correo"));
            tvTelefono.setText("Teléfono: " + extras.getString("telefono"));
        }
    }
}