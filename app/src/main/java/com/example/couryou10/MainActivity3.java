package com.example.couryou10;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class MainActivity3 extends AppCompatActivity {
    EditText et5;
    Button bt5;
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tv1 = findViewById(R.id.tv1);
    }

    public void retornar(View v) {
        finish();
    }

    String re = "";
    float prinum;
    float segnum;
    String operador;

    public void uno(View view) {
        re += "1";
        tv1.setText(re);
    }

    public void dos(View view) {
        re += "2";
        tv1.setText(re);
    }

    public void tres(View view) {
        re += "3";
        tv1.setText(re);
    }

    public void cuatro(View view) {
        re += "4";
        tv1.setText(re);
    }

    public void cinco(View view) {
        re += "5";
        tv1.setText(re);
    }

    public void seix(View view) {
        re += "6";
        tv1.setText(re);
    }

    public void siete(View view) {
        re += "7";
        tv1.setText(re);
    }

    public void ocho(View view) {
        re += "8";
        tv1.setText(re);
    }

    public void nueve(View view) {
        re += "9";
        tv1.setText(re);
    }

    public void cero(View view) {
        re += "0";
        tv1.setText(re);
    }

    public void borrar(View view) {
        re = ""; // Reinicia la variable que almacena los números
        tv1.setText("");
    }

    public void otrob(View view) {
        // Obtener el valor actual del TextView
        String c = tv1.getText().toString();
        // Verificar si la longitud es mayor que 0 para evitar errores
        int n = c.length();
        if (n > 0) {
            // Eliminar el último carácter de la cadena
            c = c.substring(0, n - 1);
            tv1.setText(c);
            // Actualizar la variable 're' con el nuevo valor del TextView
            re = c;
        }
    }

    public void suma(View view) {
        prinum = Float.parseFloat(tv1.getText().toString());
        operador = "+";
        re = "";
        tv1.setText(re);
    }

    public void resta(View view) {
        prinum = Float.parseFloat(tv1.getText().toString());
        re = "";
        operador = "-";
        tv1.setText(re);
    }

    public void multi(View view) {
        prinum = Float.parseFloat(tv1.getText().toString());
        re = "";
        operador = "*";
        tv1.setText(re);
    }

    public void divi(View view) {
        prinum = Float.parseFloat(tv1.getText().toString());
        re = "";
        operador = "/";
        tv1.setText(re);
    }

    public void igual(View view) {
        if (operador == null) {
            tv1.setText("Error");
            return;
        }

        // Obtener el segundo número
        try {
            segnum = Float.parseFloat(tv1.getText().toString());
        } catch (NumberFormatException e) {
            // Manejo de excepción si no se puede convertir el texto a número
            tv1.setText("Error");
            return;
        }

        // Realizar la operación basada en el operador
        float resultado = 0;
        switch (operador) {
            case "+":
                resultado = prinum + segnum;
                break;
            case "-":
                resultado = prinum - segnum;
                break;
            case "/":
                if (segnum != 0) {
                    resultado = prinum / segnum;
                } else {
                    tv1.setText("Error: División por cero"); // división por cero
                    return;
                }
                break;
            case "*":
                resultado = prinum * segnum;
                break;
            default:
                tv1.setText("Error"); // el operador no es válido
                return;
        }

        // Mostrar el resultado con formato adecuado
        tv1.setText(String.format(Locale.getDefault(), "%.2f", resultado));

        // Reiniciar el operador y los operandos
        operador = null;
        prinum = 0;
        segnum = 0;
        re = "";
    }

    public void punto(View view) {
        if (!re.contains(".")) { // Verifica si ya hay un punto
            re += "."; // Agrega el punto decimal
            tv1.setText(re);
        }
    }
}
