package com.example.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView resultado;
    private double valor1 = Double.NaN;
    private double valor2;
    private char operacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultado = findViewById(R.id.resultado);

        // Números
        Button button0 = findViewById(R.id.button10);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);

        // Operaciones
        Button buttonSumar = findViewById(R.id.buttonSumar);
        Button buttonIgual = findViewById(R.id.buttonIgual);
        Button buttonBorrar = findViewById(R.id.buttonBorrar);

        View.OnClickListener listenerNumeros = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button b = (Button) view;
                resultado.append(b.getText().toString());
            }
        };

        button0.setOnClickListener(listenerNumeros);
        button1.setOnClickListener(listenerNumeros);
        button2.setOnClickListener(listenerNumeros);
        button3.setOnClickListener(listenerNumeros);
        button4.setOnClickListener(listenerNumeros);
        button5.setOnClickListener(listenerNumeros);
        button6.setOnClickListener(listenerNumeros);
        button7.setOnClickListener(listenerNumeros);
        button8.setOnClickListener(listenerNumeros);
        button9.setOnClickListener(listenerNumeros);

        buttonSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                realizarOperacion();
                operacion = '+';
                resultado.setText(null);
            }
        });


        buttonIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                realizarOperacion();
                operacion = ' ';
            }
        });

        buttonBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valor1 = Double.NaN;
                valor2 = Double.NaN;
                resultado.setText("");
            }
        });
    }

    private void realizarOperacion() {
        if (!Double.isNaN(valor1)) {
            valor2 = Double.parseDouble(resultado.getText().toString());
            switch (operacion) {
                case '+':
                    valor1 = valor1 + valor2;
                    break;

            }
            resultado.setText(String.valueOf(valor1));
        } else {
            valor1 = Double.parseDouble(resultado.getText().toString());
        }
    }
}
