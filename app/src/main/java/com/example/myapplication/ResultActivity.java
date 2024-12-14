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
        TextView tvNombres = findViewById(R.id.tvNombres);
        TextView tvApellidos = findViewById(R.id.tvApellidos);
        TextView tvFechaNacimiento = findViewById(R.id.tvFechaNacimiento);
        TextView tvEmpresa = findViewById(R.id.tvEmpresa);
        TextView tvGenero = findViewById(R.id.tvGenero);
        TextView tvCorreo = findViewById(R.id.tvCorreo);
        TextView tvTelefono = findViewById(R.id.tvTelefono);

        // Obtener datos del Intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            tvNombres.setText("Nombre: " + extras.getString("nombres"));
            tvApellidos.setText("Apellido: " + extras.getString("apellidos"));
            tvFechaNacimiento.setText("Fecha de Nacimiento: " + extras.getString("fechaNacimiento"));
            tvEmpresa.setText("Empresa: " + extras.getString("empresa"));
            tvGenero.setText("Género: " + extras.getString("genero"));
            tvCorreo.setText("Correo: " + extras.getString("correo"));
            tvTelefono.setText("Teléfono: " + extras.getString("telefono"));
        }
    }
}