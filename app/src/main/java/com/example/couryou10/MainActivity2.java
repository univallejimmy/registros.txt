package com.example.couryou10;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    TextView tv1;
    EditText etm2;
    ArrayList<String> registros;
    String registroEncontrado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tv1 = findViewById(R.id.tv1);
        etm2 = findViewById(R.id.etm2);
        registros = leerRegistrosDesdeArchivo(); // Lee registros desde el archivo

        // Mostrar todos los registros en el TextView
        mostrarRegistros();
    }

    public void cer(View v) {
        finish();
    }

    public void buscar(View view) {
        // Obtener el ID que el usuario está buscando
        String idBuscado = etm2.getText().toString().trim();
        StringBuilder registroEncontrado = new StringBuilder(); // Usar StringBuilder para construir el registro encontrado

        // Leer registros desde el archivo
        registros = leerRegistrosDesdeArchivo();

        boolean encontrado = false; // Bandera para verificar si el ID fue encontrado

        // Buscar el registro por ID
        for (String registro : registros) {
            if (registro.startsWith("ID: " + idBuscado)) {
                encontrado = true; // Marcar que hemos encontrado el ID
            }

            // Si hemos encontrado el ID, añadir el registro a registroEncontrado
            if (encontrado) {
                registroEncontrado.append(registro).append("\n"); // Agregar la línea al registro encontrado

                // Salir si se llega a un registro vacío o se detecta que ya no hay más registros para ese ID
                if (registro.trim().isEmpty()) {
                    break;
                }
            }
        }

        // Mostrar el resultado de la búsqueda
        if (registroEncontrado.length() > 0) {
            tv1.setText(registroEncontrado.toString()); // Convertir StringBuilder a String y mostrar
        } else {
            tv1.setText("Registro no encontrado");
        }
    }







    private ArrayList<String> leerRegistrosDesdeArchivo() {
        ArrayList<String> registrosLeidos = new ArrayList<>();
        try {
            FileInputStream fis = openFileInput("registros.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fis);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String linea;

            while ((linea = bufferedReader.readLine()) != null) {
                registrosLeidos.add(linea); // Agregar cada línea leída a la lista
            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace(); // Manejo de errores
        }
        return registrosLeidos;
    }



    private void mostrarRegistros() {
        if (registros != null && !registros.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (String registro : registros) {
                sb.append(registro).append("\n");
            }
            tv1.setText(sb.toString());
        } else {
            tv1.setText("No hay registros disponibles.");
        }
    }

    public void eliminar(View view){
// Obtener el ID que el usuario desea eliminar
        String idBuscado = etm2.getText().toString().trim();

        // Leer todos los registros desde el archivo
        ArrayList<String> registros = leerRegistrosDesdeArchivo();

        // Crear una nueva lista para los registros que se conservarán
        ArrayList<String> registrosActualizados = new ArrayList<>();

        boolean encontrado = false; // Bandera para verificar si el ID fue encontrado

        for (String registro : registros) {
            // Si el registro comienza con el ID buscado, no lo añadimos
            if (registro.startsWith("ID: " + idBuscado)) {
                encontrado = true; // Marcar que hemos encontrado y eliminado el ID
                continue; // Saltar este registro
            }
            registrosActualizados.add(registro); // Agregar registros que no se eliminan
        }

        // Mostrar mensaje si el registro fue encontrado y eliminado
        if (encontrado) {
            tv1.setText("Registro eliminado.");
        } else {
            tv1.setText("Registro no encontrado.");
        }

        // Guardar la lista actualizada en el archivo
        guardarRegistrosEnArchivo(registrosActualizados);
    }
    private void guardarRegistrosEnArchivo(ArrayList<String> registros) {
        try {
            // Crea un FileOutputStream en el almacenamiento interno
            FileOutputStream fos = openFileOutput("registros.txt", MODE_PRIVATE);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fos);

            // Escribir cada registro en el archivo
            for (String registro : registros) {
                outputStreamWriter.write(registro + "\n"); // Agregar un salto de línea
            }

            // Cerrar el stream
            outputStreamWriter.close();
        } catch (IOException e) {
            e.printStackTrace(); // Manejo de errores
        }
    }
}
