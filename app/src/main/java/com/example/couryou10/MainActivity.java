package com.example.couryou10;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SimpleAdapter;
import android.widget.Spinner;

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

public class MainActivity extends AppCompatActivity {
    private EditText et1,et2,et3,et4,et5,et6,et7,et8,et9,et10,et11;
    private RadioButton rb1,rb2,rb3,rb4;
    private CheckBox cb1,cb2,cb3,cb4,cb5,cb6;
    private int currentId;
    ArrayList<String> registros = new ArrayList<>();
    private Spinner spinner;
String[] equipos = {"Cali", "America","Pasto","Millonarios","Los pulpitos"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        spinner = findViewById(R.id.spinner);
        ArrayAdapter<String>adapequipos= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1 ,equipos);
        spinner.setAdapter(adapequipos);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        et3 = findViewById(R.id.et3);
        et4 = findViewById(R.id.et4);
        et5 = findViewById(R.id.et5);
        et6 = findViewById(R.id.et6);
        et7 = findViewById(R.id.et7);
        et8 = findViewById(R.id.et8);
        et9 = findViewById(R.id.et9);
        et10 = findViewById(R.id.et10);
        et11 = findViewById(R.id.et11);

        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        rb4 = findViewById(R.id.rb4);

        cb1 = findViewById(R.id.cb1);
        cb2 = findViewById(R.id.cb2);
        cb3 = findViewById(R.id.cb3);
        cb4 = findViewById(R.id.cb4);
        cb5 = findViewById(R.id.cb5);
        cb6 = findViewById(R.id.cb6);




    }
    // Métodos get y set para el Spinner
    public Spinner getSpinner() {
        return spinner;
    }

    public void setSpinner(Spinner spinner) {
        this.spinner = spinner;
    }
    // Métodos get y set para los EditTexts
    public EditText getEt1() {
        return et1;
    }

    public void setEt1(EditText et1) {
        this.et1 = et1;
    }

    public EditText getEt2() {
        return et2;
    }

    public void setEt2(EditText et2) {
        this.et2 = et2;
    }

    public EditText getEt3() {
        return et3;
    }

    public void setEt3(EditText et3) {
        this.et3 = et3;
    }

    public EditText getEt4() {
        return et4;
    }

    public void setEt4(EditText et4) {
        this.et4 = et4;
    }
    public EditText getEt5() {
        return et5;
    }

    public void setEt5(EditText et5) {
        this.et5 = et5;
    }

    public EditText getEt6() {
        return et6;
    }

    public void setEt6(EditText et6) {
        this.et6 = et6;
    }public EditText getEt7() {
        return et7;
    }

    public void setEt7(EditText et7) {
        this.et7 = et7;
    }

    public EditText getEt8() {
        return et8;
    }

    public void setEt8(EditText et8) {
        this.et8 = et8;
    }
    public EditText getEt9() {
        return et9;
    }

    public void setEt9(EditText et9) {
        this.et8 = et9;
    }
    public EditText getEt10() {
        return et10;
    }

    public void setEt10(EditText et10) {
        this.et10 = et10;
    }
    // Métodos get y set para los CheckBoxes
    public CheckBox getCb1() {
        return cb1;
    }

    public void setCb1(CheckBox cb1) {
        this.cb1 = cb1;
    }

    public CheckBox getCb2() {
        return cb2;
    }

    public void setCb2(CheckBox cb2) {
        this.cb2 = cb2;
    }

    public CheckBox getCb3() {
        return cb3;
    }

    public void setCb3(CheckBox cb3) {
        this.cb3 = cb3;
    }

    public CheckBox getCb4() {
        return cb4;
    }

    public void setCb4(CheckBox cb4) {
        this.cb4 = cb4;
    }

    public CheckBox getCb5() {
        return cb5;
    }

    public void setCb5(CheckBox cb5) {
        this.cb5 = cb5;
    }

    public CheckBox getCb6() {
        return cb6;
    }

    public void setCb6(CheckBox cb6) {
        this.cb6 = cb6;
    }

    // Métodos get y set para los RadioButtons
    public RadioButton getRb1() {
        return rb1;
    }

    public void setRb1(RadioButton rb1) {
        this.rb1 = rb1;
    }

    public RadioButton getRb2() {
        return rb2;
    }

    public void setRb2(RadioButton rb2) {
        this.rb2 = rb2;
    }
    public RadioButton getRb3() {
        return rb3;
    }

    public void setRb3(RadioButton rb3) {
        this.rb3 = rb3;
    }

    public RadioButton getRb4() {
        return rb4;
    }

    public void setRb4(RadioButton rb4) {
        this.rb4 = rb4;
    }
    //id
    public int getID() {
        return currentId; // Retornar el ID actual
    }

    public void setID(int id) {
        this.currentId = id; // Actualizar el ID actual
        et5.setText(String.valueOf(currentId));
    }

    public void guardar(View v) {
        StringBuilder nuevoRegistro = new StringBuilder();
        nuevoRegistro.append("ID: ").append(getID()).append("\n")
                .append("Nombre: ").append(getEt1().getText().toString()).append("\n")
                .append("Apellido: ").append(getEt2().getText().toString()).append("\n")
                .append("Telefono: ").append(getEt3().getText().toString()).append("\n")
                .append("Correo: ").append(getEt4().getText().toString()).append("\n")
                .append("Fecha de nacimiento: ").append(getEt5().getText().toString()).append("\n")
                .append("Direccion: ").append(getEt6().getText().toString()).append("\n")
                .append("Pelicula Favorita: ").append(getEt7().getText().toString()).append("\n")
                .append("Comida favorita: ").append(getEt8().getText().toString()).append("\n")
                .append("Cancion Favorita: ").append(getEt9().getText().toString()).append("\n")
                .append("Color Favorita: ").append(getEt10().getText().toString()).append("\n")
                .append("Categorías: ");

        String equipoSeleccionado = spinner.getSelectedItem().toString();
        registros.add("Equipo: " + equipoSeleccionado);

        // Agregar las categorías seleccionadas
        if (getCb1().isChecked()) nuevoRegistro.append("Musica, ");
        if (getCb2().isChecked()) nuevoRegistro.append("Deportes, ");
        if (getCb3().isChecked()) nuevoRegistro.append("Cine, ");
        if (getCb4().isChecked()) nuevoRegistro.append("Videojuegos, ");
        if (getCb5().isChecked()) nuevoRegistro.append("Cine, ");
        if (getCb6().isChecked()) nuevoRegistro.append("Videojuegos, ");

        // Eliminar la última coma y espacio
        if (nuevoRegistro.toString().endsWith(", ")) {
            nuevoRegistro.setLength(nuevoRegistro.length() - 2); // Elimina la última coma y espacio
        }
        nuevoRegistro.append("\n");

        // Añadir género
        if (getRb1().isChecked()) {
            nuevoRegistro.append("Género: Masculino\n");
        } else if (getRb2().isChecked()) {
            nuevoRegistro.append("Género: Femenino\n");
        }

        // Añadir estado civil
        if (getRb3().isChecked()) {
            nuevoRegistro.append("Estado Civil: Soltero\n");
        } else if (getRb4().isChecked()) {
            nuevoRegistro.append("Estado Civil: Casado\n");
        }

        // Guardar el registro en el archivo
        guardarRegistrosEnArchivo(nuevoRegistro.toString());
        // Incrementar el ID y establecerlo
        setID(getID() + 1); // Incrementar el ID actual
        et5.setText(String.valueOf(getID())); // Mostrar el nuevo ID

        // Limpiar campos
        clearFields();

        // Intent para ir a otra actividad
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }


    // Método para guardar registros en un archivo
    private void guardarRegistrosEnArchivo(String registro) {
        try {
            FileOutputStream fos = openFileOutput("registros.txt", MODE_APPEND); // Cambiar a MODE_APPEND
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fos);
            outputStreamWriter.write(registro); // Guardar el nuevo registro
            outputStreamWriter.close();
        } catch (IOException e) {
            e.printStackTrace(); // Manejo de errores
        }
    }

    private void clearFields(){
        // Limpiar campos
        getEt1().setText("");
        getEt2().setText("");
        getEt3().setText("");
        getEt4().setText("");
        getEt5().setText("");
        getEt6().setText("");
        getEt7().setText("");
        getEt8().setText("");
        getEt9().setText("");
        getEt10().setText("");
        getCb1().setChecked(false);
        getCb2().setChecked(false);
        getCb3().setChecked(false);
        getCb4().setChecked(false);
        getCb5().setChecked(false);
        getCb6().setChecked(false);
        getRb1().setChecked(false);
        getRb2().setChecked(false);
        getRb3().setChecked(false);
        getRb4().setChecked(false);
    }

    // Método para buscar y mostrar un usuario por ID
    public void modificar(View v) {
        String idBuscado = et11.getText().toString().trim();
        registros.clear(); // Limpiar la lista de registros
        String registroEncontrado = buscarRegistroPorId(idBuscado); // Buscar el registro por ID

        if (registroEncontrado != null) {
            // Parsear los datos del registro encontrado y mostrar en los EditText
            String[] datos = registroEncontrado.split("\n");
            for (String dato : datos) {
                if (dato.startsWith("ID: ")) {
                    // Aquí podrías manejar el ID si lo necesitas
                } else if (dato.startsWith("Nombre: ")) {
                    et1.setText(dato.replace("Nombre: ", ""));
                } else if (dato.startsWith("Apellido: ")) {
                    et2.setText(dato.replace("Apellido: ", ""));
                } else if (dato.startsWith("Telefono: ")) {
                    et3.setText(dato.replace("Telefono: ", ""));
                } else if (dato.startsWith("Correo: ")) {
                    et4.setText(dato.replace("Correo: ", ""));
                } else if (dato.startsWith("Fecha de nacimiento: ")) {
                    et5.setText(dato.replace("Fecha de nacimiento: ", ""));
                } else if (dato.startsWith("Direccion: ")) {
                    et6.setText(dato.replace("Direccion: ", ""));
                } else if (dato.startsWith("Pelicula Favorita: ")) {
                    et7.setText(dato.replace("Pelicula Favorita: ", ""));
                } else if (dato.startsWith("Comida favorita: ")) {
                    et8.setText(dato.replace("Comida favorita: ", ""));
                } else if (dato.startsWith("Cancion Favorita: ")) {
                    et9.setText(dato.replace("Cancion Favorita: ", ""));
                } else if (dato.startsWith("Color Favorita: ")) {
                    et10.setText(dato.replace("Color Favorita: ", ""));
                }
                // Agregar lógica para checkboxes y radiobuttons si se requiere
            }
        } else {
            // Mostrar un mensaje si no se encuentra el registro
            et11.setError("Registro no encontrado");
        }
    }

    // Método para buscar un registro por ID en el archivo
    private String buscarRegistroPorId(String id) {
        try {
            FileInputStream fis = openFileInput("registros.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fis);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String linea;
            StringBuilder registroEncontrado = new StringBuilder();

            while ((linea = bufferedReader.readLine()) != null) {
                if (linea.contains("ID: " + id)) {
                    // Si encontramos el ID, leemos el registro completo
                    registroEncontrado.append(linea).append("\n");
                    while ((linea = bufferedReader.readLine()) != null && !linea.isEmpty()) {
                        registroEncontrado.append(linea).append("\n");
                    }
                    break; // Salir del bucle una vez que encontramos el registro
                }
            }

            bufferedReader.close();
            return registroEncontrado.length() > 0 ? registroEncontrado.toString() : null; // Retornar el registro encontrado o null
        } catch (IOException e) {
            e.printStackTrace(); // Manejo de errores
            return null;
        }
    }
    public void cal(View view){
        Intent intent3 = new Intent(this, MainActivity3.class);
        startActivityForResult(intent3, 102);
    }
}