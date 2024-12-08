// MainActivity.java
package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etCedula, etNombres, etFechaNacimiento, etCiudad, etCorreo, etTelefono;
    private RadioGroup rgGenero;
    private Button btnEnviar, btnLimpiar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referencias a los controles
        etCedula = findViewById(R.id.etCedula);
        etNombres = findViewById(R.id.etNombres);
        etFechaNacimiento = findViewById(R.id.etFechaNacimiento);
        etCiudad = findViewById(R.id.etCiudad);
        etCorreo = findViewById(R.id.etCorreo);
        etTelefono = findViewById(R.id.etTelefono);
        rgGenero = findViewById(R.id.rgGenero);
        btnEnviar = findViewById(R.id.btnEnviar);
        btnLimpiar = findViewById(R.id.btnLimpiar);

        // Acción del botón Enviar
        btnEnviar.setOnClickListener(v -> {
            if (validarFormulario()) {
                // Obtener datos
                String cedula = etCedula.getText().toString();
                String nombres = etNombres.getText().toString().toUpperCase();
                String fechaNacimiento = etFechaNacimiento.getText().toString();
                String ciudad = etCiudad.getText().toString().toUpperCase();
                String genero = ((RadioButton) findViewById(rgGenero.getCheckedRadioButtonId())).getText().toString();
                String correo = etCorreo.getText().toString();
                String telefono = etTelefono.getText().toString();

                // Pasar datos a ResultActivity
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("cedula", cedula);
                intent.putExtra("nombres", nombres);
                intent.putExtra("fechaNacimiento", fechaNacimiento);
                intent.putExtra("ciudad", ciudad);
                intent.putExtra("genero", genero);
                intent.putExtra("correo", correo);
                intent.putExtra("telefono", telefono);
                startActivity(intent);
            }
        });

        // Acción del botón Limpiar
        btnLimpiar.setOnClickListener(v -> limpiarFormulario());
    }

    private boolean validarFormulario() {
        // Validar campos
        if (etCedula.getText().toString().length() != 10 || !TextUtils.isDigitsOnly(etCedula.getText())) {
            etCedula.setError("Ingrese un número de cédula válido de 10 dígitos");
            return false;
        }
        if (TextUtils.isEmpty(etNombres.getText()) || etNombres.getText().toString().length() > 500) {
            etNombres.setError("Ingrese un nombre válido (máx. 500 caracteres)");
            return false;
        }
        if (TextUtils.isEmpty(etFechaNacimiento.getText())) {
            etFechaNacimiento.setError("Ingrese una fecha válida");
            return false;
        }
        if (TextUtils.isEmpty(etCiudad.getText()) || etCiudad.getText().toString().length() > 200) {
            etCiudad.setError("Ingrese una ciudad válida (máx. 200 caracteres)");
            return false;
        }
        if (rgGenero.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Seleccione un género", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(etCorreo.getText()).matches()) {
            etCorreo.setError("Ingrese un correo electrónico válido");
            return false;
        }
        if (etTelefono.getText().toString().length() != 10 || !TextUtils.isDigitsOnly(etTelefono.getText())) {
            etTelefono.setError("Ingrese un número de teléfono válido de 10 dígitos");
            return false;
        }
        return true;
    }

    private void limpiarFormulario() {
        etCedula.setText("");
        etNombres.setText("");
        etFechaNacimiento.setText("");
        etCiudad.setText("");
        rgGenero.clearCheck();
        etCorreo.setText("");
        etTelefono.setText("");
    }
}
